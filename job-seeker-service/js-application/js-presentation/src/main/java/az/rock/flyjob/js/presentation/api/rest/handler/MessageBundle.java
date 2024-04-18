package az.rock.flyjob.js.presentation.api.rest.handler;

import az.rock.lib.valueObject.Language;
import az.rock.message.ClasspathReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class MessageBundle {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String FAIL_MESSAGE_BUNDLE_PATH = "message/fail/js_fail_messages.json";
    private static final String SUCCESS_MESSAGE_BUNDLE_PATH = "message/success/js_success_messages.json";
    public static List<Message> FAIL_MESSAGE_LIST;
    public static List<Message> SUCCESS_MESSAGE_LIST;

    static {
        try {
            var failContext = ClasspathReader.asString(FAIL_MESSAGE_BUNDLE_PATH);
            FAIL_MESSAGE_LIST = OBJECT_MAPPER.readValue(failContext, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Message.class));
            var successContext = ClasspathReader.asString(SUCCESS_MESSAGE_BUNDLE_PATH);
            SUCCESS_MESSAGE_LIST = OBJECT_MAPPER.readValue(failContext, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Message.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String fail(String code, Language lang) {
        return MessageBundle.getMessage(code, lang, FAIL_MESSAGE_LIST);
    }

    public static String success(String code, Language lang) {
        return MessageBundle.getMessage(code, lang, SUCCESS_MESSAGE_LIST);
    }

    private static String getMessage(String code, Language lang, List<Message> messageList) {
        var message = messageList.stream()
                .filter(m -> m.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("F0000000001"));
        switch (lang.name().toLowerCase()) {
            case "az":
                return message.getAz();
            case "en":
                return message.getEn();
            case "ru":
                return message.getRu();
            case "tr":
                return message.getTr();
            default:
                return message.getEn();
        }
    }
}
