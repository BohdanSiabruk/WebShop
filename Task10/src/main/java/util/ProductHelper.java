package util;

import bin.Page;
import bin.PaginationRequest;
import constant.Constants;
import entity.Product;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.*;

import static constant.Constants.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class ProductHelper {
    private static Map<String, String> mapParameter = createMapParameter();


    private ProductHelper() {
    }

    public static String buildSQLRequest(PaginationRequest paginationRequest, String tableName) {
        StringBuilder stringBuilder = new StringBuilder(("select * from " + tableName));
        boolean flag = false;

        if (isPresentAnyParameter(paginationRequest.getMapParameterSectionWhere())) {
            stringBuilder.append(" WHERE");
            for (Map.Entry entry : paginationRequest.getMapParameterSectionWhere().entrySet()) {
                if (flag) {
                    stringBuilder.append(" and");
                }

                stringBuilder.append(" ").append(mapParameter.get(entry.getKey())).append(entry.getValue()).append("'");
                flag = true;
            }
        }
        stringBuilder.append(sortByNameAndPrice(paginationRequest));

        return stringBuilder.toString();
    }

    private static String sortByNameAndPrice(PaginationRequest paginationRequest) {
        StringBuilder builder = new StringBuilder();
        if (paginationRequest.getListSortedParameter().size() != 0) {
            builder.append(" ORDER BY ");
            paginationRequest.getListSortedParameter().forEach((k) -> {
                if (!builder.toString().matches(" ORDER BY $")) {
                    builder.append(", ");
                }
                builder.append(k);
            });
            builder.append(" " + paginationRequest.getSorted());
        }
        return builder.toString();
    }


    private static String setLimitAndOfset(PaginationRequest paginationRequest) {

        int amountProductOnPage = 3;
        if (!isNull(paginationRequest.getAmountOnPage())) {
            amountProductOnPage = paginationRequest.getAmountOnPage();
        }

        int currentPage = 1;
        if (!isNull(paginationRequest.getPage()) && paginationRequest.getPage() != 0) {
            currentPage = paginationRequest.getPage();
        }
        return " limit " + amountProductOnPage +
                " offset " +
                ((currentPage - 1) * amountProductOnPage);
    }

    public static String createFullRequest(PaginationRequest paginationRequest, String nameTable) {
        return buildSQLRequest(paginationRequest, nameTable) + setLimitAndOfset(paginationRequest);
    }

    private static boolean isPresentAnyParameter(Map<String, String> mapCurrentParameter) {
        return mapCurrentParameter.entrySet().stream().anyMatch(e -> (nonNull(mapParameter.get(e.getKey()))));
    }

    private static Map<String, String> createMapParameter() {
        Map<String, String> mapParameter = new LinkedHashMap<>();
        mapParameter.put(PRODUCT_FIRM, "firm='");
        mapParameter.put(PRODUCT_CATEGORY, "purpose='");
        mapParameter.put(PRODUCT_PRICE_FROM, "price>='");
        mapParameter.put(PRODUCT_PRICE_TO, "price<='");

        return mapParameter;
    }


    public static int setAmountPages(double count, int amountOnPage) throws SQLException {

        return (int) Math.ceil(count / amountOnPage);
    }

    public static PaginationRequest createProductParameterForm(HttpServletRequest req) {
        Map<String, String> mapParameterSectionWhere = new HashMap<>();
        PaginationRequest paginationRequest = new PaginationRequest();

        mapParameter.forEach((k, v) -> {
            if (!isEmpty(req.getParameter(k))) {
                mapParameterSectionWhere.put(k, req.getParameter(k));
            }
        });
        paginationRequest.setMapParameterSectionWhere(mapParameterSectionWhere);
        List<String> listOrderParameter = new ArrayList<>();

        if (!isEmpty(req.getParameter(PRODUCT_SORT_BY_NAME))) {
            listOrderParameter.add(req.getParameter(PRODUCT_SORT_BY_NAME));

        }
        if (!isEmpty(req.getParameter(PRODUCT_SORT_BY_PRICE))) {
            listOrderParameter.add(req.getParameter(PRODUCT_SORT_BY_PRICE));
        }
        paginationRequest.setListSortedParameter(listOrderParameter);

        if (!isEmpty(req.getParameter(PRODUCT_ENUMERATION))) {
            paginationRequest.setSorted(req.getParameter(PRODUCT_ENUMERATION));
        }

        if (!isEmpty(req.getParameter(PRODUCT_AMOUNT_ON_PAGE))) {
            paginationRequest.setAmountOnPage(Integer.parseInt(req.getParameter(PRODUCT_AMOUNT_ON_PAGE)));
        } else {
            paginationRequest.setAmountOnPage(3);
        }

        if (!isEmpty(req.getParameter(PRODUCT_CURRENT_PAGE))) {
            paginationRequest.setPage(Integer.parseInt(req.getParameter(PRODUCT_CURRENT_PAGE)));
        }

        if (!isEmpty(req.getParameter(PRODUCT_LIMIT_ON_PAGE))) {
            paginationRequest.setLimit(Integer.parseInt(req.getParameter(PRODUCT_LIMIT_ON_PAGE)));
        } else {
            paginationRequest.setLimit(3);
        }

        if (!isEmpty(req.getParameter(PRODUCT_OFFSET))) {
            paginationRequest.setOffset(Integer.parseInt(req.getParameter(PRODUCT_OFFSET)));
        } else {
            paginationRequest.setOffset(0);
        }


        return paginationRequest;
    }


    public static void addParameterToRequest(HttpServletRequest request, PaginationRequest paginationRequest, Page<Product> page) {

        if (paginationRequest.getMapParameterSectionWhere().size() != 0) {
            paginationRequest.getMapParameterSectionWhere().forEach(request::setAttribute);
        }

        if (paginationRequest.getListSortedParameter().size() != 0) {
            paginationRequest.getListSortedParameter().forEach((k) -> request.setAttribute(k, k));
        }

        request.setAttribute(PRODUCT_AMOUNT_ON_PAGE, paginationRequest.getAmountOnPage());
        request.setAttribute(PRODUCT_ENUMERATION, String.valueOf(paginationRequest.getSorted()).toLowerCase());
        if (page.getProductList().size() != 0) {
            request.setAttribute(PRODUCT_LIST, page.getProductList());
        } else {
            request.setAttribute(PRODUCT_EMPTY_LIST, Constants.PRODUCT_LIST_EMPTY);
        }
        request.setAttribute(PRODUCT_COUNT_PAGES, page.getPage());

    }
}
