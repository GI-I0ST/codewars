package com.ghost.paginationhelper;

import java.util.List;

/**
 *For this exercise you will be strengthening your page-fu mastery. You will complete the PaginationHelper class, which
 * is a utility class helpful for querying paging information related to an array.
 *
 * The class is designed to take in an array of values and an integer indicating how many items will be allowed per each
 * page. The types of values contained within the collection/array are not relevant.
 *
 * The following are some examples of how this class is used:
 *
 * PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
 * helper.pageCount(); // should == 2
 * helper.itemCount(); // should == 6
 * helper.pageItemCount(0); // should == 4
 * helper.pageItemCount(1); // last page - should == 2
 * helper.pageItemCount(2); // should == -1 since the page is invalid
 *
 * // pageIndex takes an item index and returns the page that it belongs on
 * helper.pageIndex(5); // should == 1 (zero based index)
 * helper.pageIndex(2); // should == 0
 * helper.pageIndex(20); // should == -1
 * helper.pageIndex(-10); // should == -1
 */

public class PaginationHelper<I> {
    private final int itemCount;
    private final int itemsPerPage;
    private final int pageCount;

    public PaginationHelper(final List<I> items, final int itemsPerPage) {
        this(items.size(), itemsPerPage);
    }

    public PaginationHelper(final int itemCount, final int itemsPerPage) {
        this.itemCount = itemCount;
        this.itemsPerPage = itemsPerPage;
        pageCount = (int) Math.ceil(itemCount / (double) itemsPerPage);
    }

    public int itemCount() {
        return itemCount;
    }

    public int pageCount() {
        return pageCount;
    }

    public int pageItemCount(final int pageIndex) {
        final int lastPageIndex = pageCount - 1;
        if (pageIndex < 0 || pageIndex > lastPageIndex) {
            return -1;
        }
        if (pageIndex < lastPageIndex) {
            return itemsPerPage;
        }
        return itemCount - itemsPerPage * lastPageIndex;
    }

    public int pageIndex(final int itemIndex) {
        if (itemIndex < 0 || itemIndex >= itemCount) {
            return -1;
        }
        return itemIndex / itemsPerPage;
    }
}
