package com.tencent.supersonic.headless.core.pojo;

import com.tencent.supersonic.headless.api.pojo.QueryParam;
import com.tencent.supersonic.headless.api.pojo.response.SemanticSchemaResp;
import com.tencent.supersonic.headless.core.translator.calcite.s2sql.Ontology;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

@Data
public class QueryStatement {

    private Long dataSetId;
    private List<Long> modelIds;
    private String sql;
    private String errMsg;
    private QueryParam queryParam;
    private MetricQueryParam metricQueryParam;
    private DataSetQueryParam dataSetQueryParam;
    private Integer status = 0;
    private Boolean isS2SQL = false;
    private List<ImmutablePair<String, String>> timeRanges;
    private Boolean enableOptimize = true;
    private Triple<String, String, String> minMaxTime;
    private String dataSetSql;
    private String dataSetAlias;
    private String dataSetSimplifySql;
    private Boolean enableLimitWrapper = false;
    private Ontology ontology;
    private SemanticSchemaResp semanticSchemaResp;
    private Integer limit = 1000;
    private Boolean isTranslated = false;

    public boolean isOk() {
        return StringUtils.isBlank(errMsg) && StringUtils.isNotBlank(sql);
    }

    public boolean isTranslated() {
        return isTranslated != null && isTranslated && isOk();
    }

    public QueryStatement error(String msg) {
        this.setErrMsg(msg);
        return this;
    }
}
