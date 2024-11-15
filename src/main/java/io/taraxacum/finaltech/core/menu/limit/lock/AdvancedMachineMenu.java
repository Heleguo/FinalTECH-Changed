package io.taraxacum.finaltech.core.menu.limit.lock;

import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.taraxacum.finaltech.core.helper.Icon;
import io.taraxacum.finaltech.core.item.machine.AbstractMachine;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;

/**
 * @author Final_ROOT
 * @since 1.0
 */
public class AdvancedMachineMenu extends AbstractLockMachineMenu {
    public static final int STATUS_SLOT = 22;
    public static final int MODULE_SLOT = 31;
    private static final int[] BORDER = new int[]{3, 4, 5, 12, 14, 21, 23, 30, 32, 39, 40, 41, 48, 49, 50};
    private static final int[] INPUT_BORDER = new int[]{2, 11, 20, 29, 38, 47};
    private static final int[] OUTPUT_BORDER = new int[]{6, 15, 24, 33, 42, 51};
    private static final int[] INPUT_SLOT = new int[]{0, 1, 9, 10, 18, 19, 27, 28, 36, 37, 45, 46};
    private static final int[] OUTPUT_SLOT = new int[]{7, 8, 16, 17, 25, 26, 34, 35, 43, 44, 52, 53};

    public AdvancedMachineMenu(@Nonnull AbstractMachine abstractMachine) {
        super(abstractMachine);
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
        this.addCustomItem(STATUS_SLOT, Icon.QUANTITY_MODULE_ICON);
        this.addMenuClickHandler(STATUS_SLOT, ChestMenuUtils.getEmptyClickHandler());
    }

    @Override
    public void newInstance(@Nonnull BlockMenu blockMenu, @Nonnull Block block) {
        super.newInstance(blockMenu, block);
        blockMenu.addMenuOpeningHandler(p -> AdvancedMachineMenu.this.updateInventory(blockMenu.toInventory(), block.getLocation()));
    }
}
