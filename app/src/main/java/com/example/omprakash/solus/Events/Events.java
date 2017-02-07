package com.example.omprakash.solus.Events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Events {

    public static final List<Events> ITEMS = new ArrayList<Events>();

    public static final Map<String, Events> ITEM_MAP = new HashMap<String, Events>();

    private static final int COUNT = 25;

    public String getTitle() {
        return title;
    }

    public final String title;

        public Events(String content) {
            this.title = content;
        }

        @Override
        public String toString() {
            return title;
        }
}
