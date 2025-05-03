package org.mongine.utils;

public class Constants {
    public static class CommonContstants {
        public final static String ID = "_id";
        public final static String UNDERSCORE = "_";
        public final static String DURATION = "duration";
        public final static String DATE_TO_STRING = "dateToString";
        public final static String AVG = "average";
        public final static String AVG_SHORT = "avg";
        public final static String MINIMUM = "min";
        public final static String MAXIMUM = "max";
        public final static String SUMMATION = "sum";
        public final static String FORMAT = "format";
        public final static String DATE = "date";
    }

    public static class OperatorContstants {
        public final static String DOLLAR = "$";
        public final static String $_ID = "$_id";
        public final static String GTE = "$gte";
        public final static String LT = "$lt";
        public final static String EQUAL = "$eq";
        public final static String NOT_EQUAL = "$ne";
        public final static String IN = "$in";
        public final static String COND = "$cond";
        public final static String AVERAGE = "$avg";
        public final static String MATCH = "$match";
        public final static String MAX = "$max";
        public final static String MIN = "$min";
        public final static String CONCAT = "$concat";
        public final static String TO_UPPER = "$toUpper";
        public final static String SUBSTRCP = "$substrCP";
        public final static String TO_LOWER = "$toLower";
        public final static String STRLENCP = "$strLenCP";
        public final static String SORT = "$sort";
        public final static String GROUP = "$group";
        public final static String PROJECT = "$project";
        public final static String LIMIT = "$limit";
        public final static String SKIP = "$skip";
        public final static String SUBTRACT = "$subtract";
        public final static String MULTIPLY = "$multiply";
        public final static String SUM = "$sum";
        public final static String EXPR = "$expr";
        public final static String DIVIDE = "$divide";
        public final static String ADD = "$add";
        public final static String IF_NULL = "$ifNull";
        public final static String DATE_TO_STRING_OP = "$dateToString";
        public final static String EVENT_TIME_OP = "$event_time";
        public final static String TO_LONG_OP = "$toLong";
        public final static String FLOOR_OP = "$floor";
        public final static String TO_DATE_OP = "$toDate";
        public final static int ASC = 1;
        public final static int DESC = -1;
        public final static String PUSH = "$push";
        public final static String FIRST = "$first";
        public final static String ARRAY_ELEM_AT = "$arrayElemAt";
        public final static String COUNT_OP = "$count";

    }

    public static class MetaField {
        public final static String META_TENANT_ID = "meta_field.tenant_id";
        public final static String META_SITE_ID = "meta_field.site_id";
        public final static String META_ELEMENT_ID = "meta_field.element_id";
        public final static String META_APP_ID = "meta_field.app_id";
    }

}
