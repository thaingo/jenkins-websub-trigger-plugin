package io.jenkins.plugins.websub;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.Charsets;
import com.google.common.io.CharStreams;
import org.slf4j.helpers.MessageFormatter;

import java.io.IOException;
import java.io.InputStreamReader;

public class WebSubUtils {
    public static String fmt(final String formatString, final Object... objects) {
        return MessageFormatter.arrayFormat(formatString, objects).getMessage();
    }

    public static String getHttpResponseBody(final HttpResponse response) throws IOException {
        String charset = response.getContentEncoding();
        if (charset == null)
            charset = Charsets.UTF_8.name();
        return CharStreams.toString(new InputStreamReader(response.getContent(), charset));
    }
}
