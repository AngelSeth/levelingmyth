package mythcore.levelingcore.blocks.entities;

import mythcore.levelingcore.items.ModItems;
import mythcore.levelingcore.screens.ManaFurnaceScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.Main;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ManaFurnaceBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {

    private static final int INPUT_SLOT = 0;
    private static final int FUEL_SLOT = 2;
    private static final int MAIN_OUTPUT = 1;
    private static final int EXTRA_OUTPUT = 3;
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    public ManaFurnaceBlockEntity(BlockPos pos, BlockState state) {

        super(ModBlockEntities.MANA_FURNACE_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index){
                  case 0 -> ManaFurnaceBlockEntity.this.progress;
                  case 1 -> ManaFurnaceBlockEntity.this.maxProgress;
                  default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> ManaFurnaceBlockEntity.this.progress = value;
                    case 1 -> ManaFurnaceBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 4;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("mana_furnace");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ManaFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt){
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("mana_furnace.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt){
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("mana_furnace.progress");
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()){
            return;
        }
        if(isOutputSlotEmptyOrReceivable()){
            if(this.hasRecipe()) {
                this.increaseCraftProgress();
                markDirty(world, pos, state);

                if(hasCraftingFinished()) {
                    this.craftItem();
                    this.resetProgress();
                }
            } else {
                this.resetProgress();
            }
        } else {
            this.resetProgress();
            markDirty(world, pos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        this.removeStack(INPUT_SLOT, 1);
        this.removeStack(FUEL_SLOT, 1);
        ItemStack result = new ItemStack(ModItems.IMPURE_MYTHRIL_INGOT);
        ItemStack dust = new ItemStack(ModItems.MAGIC_DUST);
        this.setStack(MAIN_OUTPUT, new ItemStack(result.getItem(), getStack(MAIN_OUTPUT).getCount() + result.getCount()));
        this.setStack(EXTRA_OUTPUT, new ItemStack(dust.getItem(), getStack(EXTRA_OUTPUT).getCount() + dust.getCount()));
    }

    private void useFuel() {
        this.removeStack(FUEL_SLOT, 1);
        ItemStack result = new ItemStack(ModItems.MAGIC_DUST);
        this.setStack(EXTRA_OUTPUT, new ItemStack(result.getItem(), getStack(EXTRA_OUTPUT).getCount() + result.getCount()));
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        ItemStack result = new ItemStack(ModItems.IMPURE_MYTHRIL_INGOT);
        boolean hasInput = getStack(INPUT_SLOT).getItem() == ModItems.RAW_MYTHRIL;
        boolean hasFuel = getStack(FUEL_SLOT).getItem() == ModItems.CRYSTAL_SHARD;
        return hasInput && hasFuel && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(MAIN_OUTPUT).getItem() == item || this.getStack(MAIN_OUTPUT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(MAIN_OUTPUT).getCount() + result.getCount() <= getStack(MAIN_OUTPUT).getMaxCount();
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.getStack(MAIN_OUTPUT).isEmpty() || this.getStack(MAIN_OUTPUT).getCount() < this.getStack(MAIN_OUTPUT).getMaxCount();
    }

}
