package io.ezto.notify.extensions;

import io.ezto.notify.core.IDestinationProvider;
import io.ezto.notify.core.models.ProviderConfigProperty;
import io.ezto.notify.core.models.ResultResponse;
import io.ezto.notify.core.models.SourceProviderType;
import org.jobrunr.jobs.context.JobContext;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SampleDestinationProvider implements IDestinationProvider {


    @Override
    public String getProviderId() {
        return "sample_dt";
    }

    @Override
    public SourceProviderType getType() {
        return SourceProviderType.DESTINATION;
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
    public boolean testConfig(Map<String, Object> config) throws Exception {

        return true;
    }

    @Override
    public String getDisplayName() {
        return "Sample Destination";
    }

    private static List<ProviderConfigProperty> configProperties = new ArrayList<>();

    static {
        configProperties.add(ProviderConfigProperty.builder().name("hello")
                .label("Hello Dest")
                .type(ProviderConfigProperty.STRING_TYPE)
                .isRequired(true)
                .build());
    }

    @Override
    public List<ProviderConfigProperty> configs() {
        return configProperties;
    }

    @Override
    public void execute(Map<String, Object> config, Map<String, Object> ruleConfig, ResultResponse request, JobContext jobContext) throws JSONException, InterruptedException {

    }

    @Override
    public List<ProviderConfigProperty> ruleProperties(ResultResponse dsPreviewResult) {
        List<ProviderConfigProperty> providerConfigProperties = new ArrayList<>();
        providerConfigProperties.add(ProviderConfigProperty.builder().name("rule_dest")
                .label("Hello From Rule")
                .type(ProviderConfigProperty.STRING_TYPE)
                .build()
        );
        return providerConfigProperties;
    }
}
