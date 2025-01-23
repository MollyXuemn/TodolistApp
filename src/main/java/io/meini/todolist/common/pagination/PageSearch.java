package io.meini.todolist.common.pagination;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public class PageSearch <T> implements Pageable{
    private int limit =1;
    private int offset=0;
    @JsonIgnore
    private final Specification<T> search;
    private Sort sort = Sort.unsorted();

    public PageSearch(int limit, int offset, Specification<T> search, Sort sort) {
        super();
        this.limit = limit;
        this.offset = offset;
        this.search = search;
        this.sort = sort;
    }

    public PageSearch(PageSearch pageSearch, Specification<T> search) {
        this(
                pageSearch.limit,
                pageSearch.offset,
                pageSearch.search,
                pageSearch.sort
        );
    }

    public PageSearch(Specification<T> search) {
        this.search = search;
    }

    public Specification<T>  getSearch() {
        return search;
    }
    public int getLimit() {
        return limit;
    }

    public int getPageNumber() {
        return (int) Math.ceil(offset/limit);
    }

    public int getPageSize() {
        return limit;
    }

    public long getOffset() {
        return offset;
    }

    public Sort getSort() {
        return sort;
    }

    public Pageable next() {
        return null;
    }

    public Pageable previousOrFirst() {
        return null;
    }

    public Pageable first() {
        return null;
    }

    public Pageable withPage(int pageNumber) {
        return null;
    }

    public boolean hasPrevious() {
        return false;
    }
    public static <T> Builder<T> builder() {
        return new Builder<>();
    }
    public static class Builder<T> {
        private int limit;
        private int offset;
        private Specification<T> search;
        private Sort sort;

        public Builder() {
        }

        public Builder<T> limit(int limit) {
            this.limit = limit;
            return this;
        }

        public Builder<T> offset(int offset) {
            this.offset = offset;
            return this;
        }

        public Builder<T> search(Specification<T> search) {
            this.search = search;
            return this;
        }

        public Builder<T> sort(Sort sort) {
            this.sort = sort;
            return this;
        }

        public PageSearch<T> build() {
            return new PageSearch<>(limit, offset, search, sort);
        }
    }

}
