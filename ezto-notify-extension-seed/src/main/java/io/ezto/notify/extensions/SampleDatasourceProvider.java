package io.ezto.notify.extensions;

import io.ezto.notify.core.IDataSourceProvider;
import io.ezto.notify.core.IDestinationProvider;
import io.ezto.notify.core.models.ProviderConfigProperty;
import io.ezto.notify.core.models.ResultResponse;
import io.ezto.notify.core.models.ResultType;
import io.ezto.notify.core.models.SourceProviderType;
import org.jobrunr.jobs.context.JobContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDatasourceProvider implements IDataSourceProvider {


    @Override
    public String getProviderId() {
        return "sample_ds";
    }

    @Override
    public SourceProviderType getType() {
        return SourceProviderType.DATA_SOURCE;
    }

    @Override
    public boolean hasConfig() {
        return true;
    }


    @Override
    public boolean hasTestConfig() {
        return true;
    }

    @Override
    public boolean hasRuleConfig() {
        return true;
    }


    private static List<ProviderConfigProperty> configProperties = new ArrayList<>();

    static {
        configProperties.add(ProviderConfigProperty.builder().name("hello")
                .label("Hello DataSource")
                .type(ProviderConfigProperty.STRING_TYPE)
                .isRequired(true)
                .build());
    }

    @Override
    public List<ProviderConfigProperty> configs() {
        return configProperties;
    }

    @Override
    public String getDisplayName() {
        return "Sample Datasource";
    }


    @Override
    public boolean testConfig(Map<String, Object> config) throws Exception {
       return true;
    }


    @Override
    public ResultResponse execute(Map<String, Object> config) throws Exception {
        return ResultResponse.builder().build();
    }

    @Override
    public ResultResponse ruleExecute(Map<String, Object> config, Map<String, Object> request) throws Exception {
        return ResultResponse.builder().build();
    }

    @Override
    public List<ProviderConfigProperty> ruleProperties(ResultResponse executeResult) {
        List<ProviderConfigProperty> providerConfigProperties = new ArrayList<>();
        providerConfigProperties.add(ProviderConfigProperty.builder().name("rule_ds")
                .label("Hello From Rule")
                .type(ProviderConfigProperty.STRING_TYPE)
                .build()
        );
        return providerConfigProperties;
    }
}
