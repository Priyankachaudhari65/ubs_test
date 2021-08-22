package hackerrank;

import java.util.HashMap;
import java.util.stream.Collectors;

public class FurnitureOrder implements FurnitureOrderInterface {

    private final HashMap<Furniture, Integer> furnitureOrders;
    /**
     * Initialize a new mapping of Furniture types to order quantities.
     * @param
     */
    FurnitureOrder() {
        this.furnitureOrders = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        int count = 0;
        if (furnitureOrders.containsKey(type)) {
            count = furnitureOrders.get(type);
        }
        furnitureOrders.put(type,count + furnitureCount);

    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return new HashMap<Furniture, Integer>(furnitureOrders);
    }

    public float getTotalOrderCost() {
        if (!furnitureOrders.isEmpty()) {
            return furnitureOrders.entrySet().stream().
                    map(fo -> fo.getKey().cost() * fo.getValue()).
                    collect(Collectors.toList()).
                    stream().
                    reduce(Float::sum).get();
        }
        return 0.0f;
    }

    public int getTypeCount(Furniture type) {
        if (furnitureOrders.containsKey(type)) {
            return furnitureOrders.get(type);
    }
        return 0;
    }

    public float getTypeCost(Furniture type) {
        if (furnitureOrders.containsKey(type)) {
            return furnitureOrders.get(type) * type.cost();

        }
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
        if (!furnitureOrders.isEmpty()) {
            return furnitureOrders.values().stream().reduce(Integer::sum).get();
        }
        return 0;
    }
}