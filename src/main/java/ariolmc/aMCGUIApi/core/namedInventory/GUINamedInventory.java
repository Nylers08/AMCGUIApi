package ariolmc.aMCGUIApi.core.namedInventory;

import ariolmc.aMCGUIApi.core.menu.utils.InventoryUtils;
import ariolmc.aMCGUIApi.infrastructure.inventoryFactory.InventoryCreator;
import lombok.Getter;
import lombok.Setter;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class GUINamedInventory implements NamedInventory{

    @Getter private Component title;
    @Getter @Setter private Inventory inventory;

    @Getter private final InventoryCreator creator;

    public GUINamedInventory(InventoryCreator creator, InventoryHolder holder, int size, Component title){
        this.title = title;
        this.inventory = creator.create(holder, size, title);
        this.creator = creator;
    }

    @Override
    public void rename(Component title){
        this.title = title;
        InventoryUtils utils = new InventoryUtils(creator);
        inventory = utils.copyWithNewTitle(inventory, title);
    }


    @Override
    public void setItem(int slot, ItemStack itemStack){
        inventory.setItem(slot, itemStack);
    }

    @Override
    public ItemStack getItem(int slot){
        return inventory.getItem(slot);
    }

    @Override
    public void setContents(ItemStack[] contents){
        inventory.setContents(contents);
    }

    @Override
    public void copyContentsWithSize(ItemStack[] contents) {
        int contentsSize = contents.length;
        if(contentsSize != getSize())
            createNewInvWithNewSize(contentsSize);
        setContents(contents);
    }

    @Override
    public void changeSize(int size) {
        checkSizeCorrectOrThrow(size);

        ItemStack[] croppedContents = getCroppedContents(size);
        createNewInvWithNewSize(size);
        setContents(croppedContents);
    }

    @Override
    public void createNewInvWithNewSize(int size) {
        checkSizeCorrectOrThrow(size);
        inventory = creator.create(inventory.getHolder(), size, title);
    }

    public ItemStack[] getContents(){
        return inventory.getContents();
    }

    @Override
    public int getSize() {
        return inventory.getSize();
    }


    private void checkSizeCorrectOrThrow(int size){
        if(isMultiple9(size) && correctSize(size)) return;
        throw new InvalidInventorySize(title, size);
    }

    private boolean isMultiple9(int value){
        return value%9==0;
    }

    private boolean correctSize(int value){
        return (value >= 9) && (value <=54);
    }

    private ItemStack[] getCroppedContents(int size){
        ItemStack[] contents = inventory.getContents();
        if(contents.length>size){
            return Arrays.copyOf(contents,size);
        }
        return contents;
    }
}
