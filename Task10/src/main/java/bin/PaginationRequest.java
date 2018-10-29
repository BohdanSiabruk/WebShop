package bin;

import enumeration.Sorted;

import java.util.List;
import java.util.Map;

public class PaginationRequest {

    private Map<String, String> mapParameterSectionWhere;
    private List<String> listSortedParameter;
    private Sorted sorted;
    private int page;
    private int amountOnPage;
    private int limit;
    private int offset;



    public Sorted getSorted() {
        return sorted;
    }


    public void setSorted(String string) {
        if (string.equals("asc")){
            this.sorted = Sorted.ASC;
        } else {
            this.sorted = Sorted.DESC;
        }
    }

    public Map<String, String> getMapParameterSectionWhere() {
        return mapParameterSectionWhere;
    }

    public void setMapParameterSectionWhere(Map<String, String> mapParameterSectionWhere) {
        this.mapParameterSectionWhere = mapParameterSectionWhere;
    }

    public List<String> getListSortedParameter() {
        return listSortedParameter;
    }

    public void setListSortedParameter(List<String> listSortedParameter) {
        this.listSortedParameter = listSortedParameter;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getAmountOnPage() {
        return amountOnPage;
    }

    public void setAmountOnPage(int amountOnPage) {
        this.amountOnPage = amountOnPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
