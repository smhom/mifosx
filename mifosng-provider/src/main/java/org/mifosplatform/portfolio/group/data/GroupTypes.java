package org.mifosplatform.portfolio.group.data;

import java.util.HashMap;
import java.util.Map;

public enum GroupTypes {

    CENTER(new Long(1), "groupTypes.center", "center"), //
    GROUP(new Long(2), "groupTypes.group", "group"), //
    INVALID(new Long(99), "lendingStrategy.invalid", "invalid");

    private Long id;
    private String code;
    private String value;

    GroupTypes(final Long id, final String code, final String value) {
        this.id = id;
        this.code = code;
        this.value = value;
    }

    private static final Map<Long, GroupTypes> intToEnumMap = new HashMap<Long, GroupTypes>();
    private static long minValue;
    private static long maxValue;
    static {
        int i = 0;
        for (final GroupTypes type : GroupTypes.values()) {
            if (i == 0) {
                minValue = type.id;
            }
            intToEnumMap.put(type.id, type);
            if (minValue >= type.id) {
                minValue = type.id;
            }
            if (maxValue < type.id) {
                maxValue = type.id;
            }
            i = i + 1;
        }
    }

    public static GroupTypes fromInt(final int i) {
        final GroupTypes type = intToEnumMap.get(Integer.valueOf(i));
        return type;
    }

    public static long getMinValue() {
        return minValue;
    }

    public static long getMaxValue() {
        return maxValue;
    }

    @Override
    public String toString() {
        return name().toString();
    }

    public Long getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }

}
