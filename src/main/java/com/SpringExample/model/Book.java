package com.SpringExample.model;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Book implements Serializable {

    private String isbn;
    private String sm;
    private String lb;

    private Integer yssl;
    private Double dj;

    private Date cbrq;

}
