package com.wurf.qifconvert.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class CsvEntry {

    private static ToStringStyle TO_STRING = new CsvToStringStyle();


    public abstract String getHeader();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, TO_STRING).replaceAll("<null>", "");
    }

    private static final class CsvToStringStyle extends ToStringStyle {
        CsvToStringStyle() {
            super();
            this.setFieldSeparator(";");
            this.setUseClassName(false);
            this.setUseIdentityHashCode(false);
            this.setUseFieldNames(false);
            this.setContentStart("");
            this.setContentEnd("");
        }

    }

}
