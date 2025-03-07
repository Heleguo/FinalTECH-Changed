package io.taraxacum.finaltech.core.menu.cargo;

import io.taraxacum.finaltech.core.helper.*;
import io.taraxacum.finaltech.core.item.machine.AbstractMachine;
import io.taraxacum.finaltech.core.menu.AbstractMachineMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nonnull;
 
public class AdvancedMeshTransferMenu extends AbstractMachineMenu {
    public static final int[] ITEM_MATCH = new int[]{27, 28, 29, 36, 37, 38, 45, 46, 47};
    private static final int[] BORDER = new int[0];
    private static final int[] INPUT_BORDER = new int[]{5, 14, 23};
    private static final int[] OUTPUT_BORDER = new int[]{32, 41, 50};
    private static final int[] INPUT_SLOT = new int[]{6, 7, 8, 15, 16, 17, 24, 25, 26};
    private static final int[] OUTPUT_SLOT = new int[]{33, 34, 35, 42, 43, 44, 51, 52, 53};
    private static final int POSITION_NORTH_SLOT = 1;
    private static final int POSITION_EAST_SLOT = 11;
    private static final int POSITION_SOUTH_SLOT = 19;
    private static final int POSITION_WEST_SLOT = 9;
    private static final int POSITION_UP_SLOT = 0;
    private static final int POSITION_DOWN_SLOT = 18;
    private static final int CARGO_FILTER_SLOT = 10;
    private static final int INPUT_BLOCK_SEARCH_MODE_SLOT = 2;
    private static final int OUTPUT_BLOCK_SEARCH_MODE_SLOT = 20;
    private static final int INPUT_CARGO_NUMBER_SUB_SLOT = 3;
    private static final int INPUT_CARGO_NUMBER_MODE_SLOT = 12;
    private static final int INPUT_CARGO_NUMBER_ADD_SLOT = 21;
    private static final int INPUT_SLOT_SEARCH_SIZE_SLOT = 4;
    private static final int INPUT_SLOT_SEARCH_ORDER_SLOT = 13;
    private static final int INPUT_CARGO_LIMIT_SLOT = 22;
    private static final int OUTPUT_CARGO_NUMBER_SUB_SLOT = 30;
    private static final int OUTPUT_CARGO_NUMBER_MODE_SLOT = 39;
    private static final int OUTPUT_CARGO_NUMBER_ADD_SLOT = 48;
    private static final int OUTPUT_SLOT_SEARCH_SIZE_SLOT = 31;
    private static final int OUTPUT_SLOT_SEARCH_ORDER_SLOT = 40;
    private static final int OUTPUT_CARGO_LIMIT_SLOT = 49;

    public AdvancedMeshTransferMenu(@Nonnull AbstractMachine machine) {
        super(machine);
    }

    @Override
    protected int[] getBorder() {
        return BORDER;
    }

    @Override
    protected int[] getInputBorder() {
        return INPUT_BORDER;
    }

    @Override
    protected int[] getOutputBorder() {
        return OUTPUT_BORDER;
    }

    @Override
    public int[] getInputSlot() {
        return INPUT_SLOT;
    }

    @Override
    public int[] getOutputSlot() {
        return OUTPUT_SLOT;
    }

    @Override
    public void init() {
        super.init();

        this.addCustomItem(POSITION_NORTH_SLOT, PositionInfo.NORTH_ICON);
        this.addCustomItem(POSITION_EAST_SLOT, PositionInfo.EAST_ICON);
        this.addCustomItem(POSITION_SOUTH_SLOT, PositionInfo.SOUTH_ICON);
        this.addCustomItem(POSITION_WEST_SLOT, PositionInfo.WEST_ICON);
        this.addCustomItem(POSITION_UP_SLOT, PositionInfo.UP_ICON);
        this.addCustomItem(POSITION_DOWN_SLOT, PositionInfo.DOWN_ICON);

        this.addCustomItem(CARGO_FILTER_SLOT, CargoFilter.HELPER.defaultIcon());
        this.addCustomItem(INPUT_BLOCK_SEARCH_MODE_SLOT, BlockSearchMode.MESH_INPUT_HELPER.defaultIcon());
        this.addCustomItem(OUTPUT_BLOCK_SEARCH_MODE_SLOT, BlockSearchMode.MESH_OUTPUT_HELPER.defaultIcon());

        this.addCustomItem(INPUT_CARGO_NUMBER_SUB_SLOT, CargoNumber.CARGO_NUMBER_SUB_ICON);
        this.addCustomItem(INPUT_CARGO_NUMBER_MODE_SLOT, CargoNumber.CARGO_NUMBER_ICON);
        this.addCustomItem(INPUT_CARGO_NUMBER_ADD_SLOT, CargoNumber.CARGO_NUMBER_ADD_ICON);
        this.addCustomItem(INPUT_SLOT_SEARCH_SIZE_SLOT, SlotSearchSize.INPUT_HELPER.defaultIcon());
        this.addCustomItem(INPUT_SLOT_SEARCH_ORDER_SLOT, SlotSearchOrder.INPUT_HELPER.defaultIcon());
        this.addCustomItem(INPUT_CARGO_LIMIT_SLOT, CargoLimit.INPUT_HELPER.defaultIcon());

        this.addCustomItem(OUTPUT_CARGO_NUMBER_SUB_SLOT, CargoNumber.CARGO_NUMBER_SUB_ICON);
        this.addCustomItem(OUTPUT_CARGO_NUMBER_MODE_SLOT, CargoNumber.CARGO_NUMBER_ICON);
        this.addCustomItem(OUTPUT_CARGO_NUMBER_ADD_SLOT, CargoNumber.CARGO_NUMBER_ADD_ICON);
        this.addCustomItem(OUTPUT_SLOT_SEARCH_SIZE_SLOT, SlotSearchSize.OUTPUT_HELPER.defaultIcon());
        this.addCustomItem(OUTPUT_SLOT_SEARCH_ORDER_SLOT, SlotSearchOrder.OUTPUT_HELPER.defaultIcon());
        this.addCustomItem(OUTPUT_CARGO_LIMIT_SLOT, CargoLimit.OUTPUT_HELPER.defaultIcon());
    }

    @Override
    public void newInstance(@Nonnull BlockMenu blockMenu, @Nonnull Block block) {
        super.newInstance(blockMenu, block);
        Inventory inventory = blockMenu.toInventory();
        Location location = block.getLocation();

        blockMenu.addMenuClickHandler(POSITION_NORTH_SLOT, PositionInfo.NORTH_HELPER.getHandler(inventory, location, this.getSlimefunItem(), POSITION_NORTH_SLOT));
        blockMenu.addMenuClickHandler(POSITION_EAST_SLOT, PositionInfo.EAST_HELPER.getHandler(inventory, location, this.getSlimefunItem(), POSITION_EAST_SLOT));
        blockMenu.addMenuClickHandler(POSITION_SOUTH_SLOT, PositionInfo.SOUTH_HELPER.getHandler(inventory, location, this.getSlimefunItem(), POSITION_SOUTH_SLOT));
        blockMenu.addMenuClickHandler(POSITION_WEST_SLOT, PositionInfo.WEST_HELPER.getHandler(inventory, location, this.getSlimefunItem(), POSITION_WEST_SLOT));
        blockMenu.addMenuClickHandler(POSITION_UP_SLOT, PositionInfo.UP_HELPER.getHandler(inventory, location, this.getSlimefunItem(), POSITION_UP_SLOT));
        blockMenu.addMenuClickHandler(POSITION_DOWN_SLOT, PositionInfo.DOWN_HELPER.getHandler(inventory, location, this.getSlimefunItem(), POSITION_DOWN_SLOT));

        blockMenu.addMenuClickHandler(CARGO_FILTER_SLOT, CargoFilter.HELPER.getHandler(inventory, location, this.getSlimefunItem(), CARGO_FILTER_SLOT));
        blockMenu.addMenuClickHandler(INPUT_BLOCK_SEARCH_MODE_SLOT, BlockSearchMode.MESH_INPUT_HELPER.getHandler(inventory, location, this.getSlimefunItem(), INPUT_BLOCK_SEARCH_MODE_SLOT));
        blockMenu.addMenuClickHandler(OUTPUT_BLOCK_SEARCH_MODE_SLOT, BlockSearchMode.MESH_OUTPUT_HELPER.getHandler(inventory, location, this.getSlimefunItem(), OUTPUT_BLOCK_SEARCH_MODE_SLOT));

        blockMenu.addMenuClickHandler(INPUT_CARGO_NUMBER_ADD_SLOT, CargoNumber.INPUT_HELPER.getNextHandler(inventory, location, this.getSlimefunItem(), INPUT_CARGO_NUMBER_MODE_SLOT));
        blockMenu.addMenuClickHandler(INPUT_CARGO_NUMBER_SUB_SLOT, CargoNumber.INPUT_HELPER.getPreviousHandler(inventory, location, this.getSlimefunItem(), INPUT_CARGO_NUMBER_MODE_SLOT));
        blockMenu.addMenuClickHandler(INPUT_CARGO_NUMBER_MODE_SLOT, CargoNumberMode.INPUT_HELPER.getHandler(inventory, location, this.getSlimefunItem(), INPUT_CARGO_NUMBER_MODE_SLOT));
        blockMenu.addMenuClickHandler(INPUT_SLOT_SEARCH_SIZE_SLOT, SlotSearchSize.INPUT_HELPER.getHandler(inventory, location, this.getSlimefunItem(), INPUT_SLOT_SEARCH_SIZE_SLOT));
        blockMenu.addMenuClickHandler(INPUT_SLOT_SEARCH_ORDER_SLOT, SlotSearchOrder.INPUT_HELPER.getHandler(inventory, location, this.getSlimefunItem(), INPUT_SLOT_SEARCH_ORDER_SLOT));
        blockMenu.addMenuClickHandler(INPUT_CARGO_LIMIT_SLOT, CargoLimit.INPUT_HELPER.getHandler(inventory, location, this.getSlimefunItem(), INPUT_CARGO_LIMIT_SLOT));

        blockMenu.addMenuClickHandler(OUTPUT_CARGO_NUMBER_ADD_SLOT, CargoNumber.OUTPUT_HELPER.getNextHandler(inventory, location, this.getSlimefunItem(), OUTPUT_CARGO_NUMBER_MODE_SLOT));
        blockMenu.addMenuClickHandler(OUTPUT_CARGO_NUMBER_SUB_SLOT, CargoNumber.OUTPUT_HELPER.getPreviousHandler(inventory, location, this.getSlimefunItem(), OUTPUT_CARGO_NUMBER_MODE_SLOT));
        blockMenu.addMenuClickHandler(OUTPUT_CARGO_NUMBER_MODE_SLOT, CargoNumberMode.OUTPUT_HELPER.getHandler(inventory, location, this.getSlimefunItem(), OUTPUT_CARGO_NUMBER_MODE_SLOT));
        blockMenu.addMenuClickHandler(OUTPUT_SLOT_SEARCH_SIZE_SLOT, SlotSearchSize.OUTPUT_HELPER.getHandler(inventory, location, this.getSlimefunItem(), OUTPUT_SLOT_SEARCH_SIZE_SLOT));
        blockMenu.addMenuClickHandler(OUTPUT_SLOT_SEARCH_ORDER_SLOT, SlotSearchOrder.OUTPUT_HELPER.getHandler(inventory, location, this.getSlimefunItem(), OUTPUT_SLOT_SEARCH_ORDER_SLOT));
        blockMenu.addMenuClickHandler(OUTPUT_CARGO_LIMIT_SLOT, CargoLimit.OUTPUT_HELPER.getHandler(inventory, location, this.getSlimefunItem(), OUTPUT_CARGO_LIMIT_SLOT));
    }

    @Override
    protected void updateInventory(@Nonnull Inventory inventory, @Nonnull Location location) {
        PositionInfo.NORTH_HELPER.checkAndUpdateIcon(inventory, location, POSITION_NORTH_SLOT);
        PositionInfo.EAST_HELPER.checkAndUpdateIcon(inventory, location, POSITION_EAST_SLOT);
        PositionInfo.SOUTH_HELPER.checkAndUpdateIcon(inventory, location, POSITION_SOUTH_SLOT);
        PositionInfo.WEST_HELPER.checkAndUpdateIcon(inventory, location, POSITION_WEST_SLOT);
        PositionInfo.UP_HELPER.checkAndUpdateIcon(inventory, location, POSITION_UP_SLOT);
        PositionInfo.DOWN_HELPER.checkAndUpdateIcon(inventory, location, POSITION_DOWN_SLOT);

        CargoFilter.HELPER.checkAndUpdateIcon(inventory, location, CARGO_FILTER_SLOT);
        BlockSearchMode.MESH_INPUT_HELPER.checkAndUpdateIcon(inventory, location, INPUT_BLOCK_SEARCH_MODE_SLOT);
        BlockSearchMode.MESH_OUTPUT_HELPER.checkAndUpdateIcon(inventory, location, OUTPUT_BLOCK_SEARCH_MODE_SLOT);

        CargoNumber.INPUT_HELPER.checkAndUpdateIcon(inventory, location, INPUT_CARGO_NUMBER_MODE_SLOT);
        CargoNumberMode.INPUT_HELPER.checkAndUpdateIcon(inventory, location, INPUT_CARGO_NUMBER_MODE_SLOT);
        SlotSearchSize.INPUT_HELPER.checkAndUpdateIcon(inventory, location, INPUT_SLOT_SEARCH_SIZE_SLOT);
        SlotSearchOrder.INPUT_HELPER.checkAndUpdateIcon(inventory, location, INPUT_SLOT_SEARCH_ORDER_SLOT);
        CargoLimit.INPUT_HELPER.checkAndUpdateIcon(inventory, location, INPUT_CARGO_LIMIT_SLOT);

        CargoNumber.OUTPUT_HELPER.checkAndUpdateIcon(inventory, location, OUTPUT_CARGO_NUMBER_MODE_SLOT);
        CargoNumberMode.OUTPUT_HELPER.checkAndUpdateIcon(inventory, location, OUTPUT_CARGO_NUMBER_MODE_SLOT);
        SlotSearchSize.OUTPUT_HELPER.checkAndUpdateIcon(inventory, location, OUTPUT_SLOT_SEARCH_SIZE_SLOT);
        SlotSearchOrder.OUTPUT_HELPER.checkAndUpdateIcon(inventory, location, OUTPUT_SLOT_SEARCH_ORDER_SLOT);
        CargoLimit.OUTPUT_HELPER.checkAndUpdateIcon(inventory, location, OUTPUT_CARGO_LIMIT_SLOT);
    }
}
