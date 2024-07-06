import java.util.ArrayList;
import java.util.List;
public class Menu {
    private List<MenuItem> items;
    private int autoIncremId;

    public Menu(){
        this.autoIncremId = 1;
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        item.setId(autoIncremId++);
        items.add(item);
    }
    public void updateItem(MenuItem item){
        for(int i=0;i<items.size();i++){
            MenuItem curr = items.get(i);
            if(curr.getId() == item.getId()){
                curr.setName(item.getName());
                curr.setPrice(item.getPrice());
                curr.setVeg(item.IsVeg());
                curr.setCategory(item.getCategory());
                break;
            }
        }
    }
    public void removeItem(int itemId){
        items.removeIf(item -> item.getId() == itemId);
    }
    public List<MenuItem> getItems(){
        return items;
    }
    public MenuItem getItemById(int id){
        for(MenuItem item:items)
            if(item.getId() == id)
                return item;
        return null;
    }
}

