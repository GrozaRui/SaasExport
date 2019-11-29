package com.rui.service.export;

import com.rui.domain.export.ExportProduct;
import com.rui.domain.export.ExportProductExample;

import java.util.List;

public interface ExportProductService {

    List<ExportProduct> findAll(ExportProductExample example);

}
