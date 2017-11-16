package ru.job4j.polymorphism;

import java.util.Arrays;

/**
 * Created on 08.08.2017.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Tracker {

    private Item item = new Item();
    private Item[] items = new Item[100];
    private int elemId = 0;

    public Item add(Item s) {
        items[elemId++] = s;
        return s;
    }

    public void update(Item s) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(s.getId())) {
                items[i] = s;
                return;
            }
        }
    }

    public void delete(Item s) {
        int n = Integer.parseInt(s.getId()) - 1;
        Item[] temp = new Item[items.length - 1];
        System.arraycopy(items, 0, temp, 0, n);
        System.arraycopy(items, n + 1, temp, n, temp.length - n);
        items = temp;
    }

    public Item[] findAll() {
        int countElenNull = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                countElenNull++;
            }
        }
        Item[] temp = new Item[items.length - countElenNull];
        System.arraycopy(items, 0, temp, 0, temp.length);
        return temp;
    }

    public Item[] findByName(String name) {
        Item[] temp = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getName().equals(name)) {
                temp[i] = items[i];
            } else {
                temp[i] = null;
            }
        }
        int n = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null) {
                n++;
            }
        }
        // 2 : allocate new array
        Item[] localAllElements = new Item[n];

        // 3 : copy not null elements
        int j = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null) {
                localAllElements[j++] = temp[i];
            }
        }
        return localAllElements;
    }

    public Item findById(String id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                return items[i];
            }
        }
        return null;
    }

    public Item[] getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Tracker{" + "items=" + "id='" + item.getId() + '\''
                + ", name='" + item.getName() + '\''
                + ", desc='" + item.getDesc() + '\''
                + ", created=" + item.getCreated()
                + ", comments=" + Arrays.toString(item.getComments()) + '}';
    }
}
