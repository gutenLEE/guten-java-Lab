package chap5;

import java.time.LocalDateTime;

/**
 * @author gutenlee
 * @since 2022/05/23
 */
public class AutoDebitRegister {
    private CardNumberValidator validator;
    private AutoDebitRepository repository;

    public AutoDebitRegister(CardNumberValidator validator, AutoDebitRepository repository) {
        this.validator = validator;
        this.repository = repository;
    }

    public RegisterResult register(AutoDebitReq req) {
        CardValidity validity = validator.validate(req.getCardNumber());

        if (validity != CardValidity.VALID) {
            return RegisterResult.error(validity);
        }
        AutoDebitInfo info = repository.findOne(req.getUserId());
        if (info != null) {
            info.changeCardNumber(req.getCardNumber());
        } else {
            AutoDebitInfo newInfo = new AutoDebitInfo(req.getUserId(), req.getCardNumber(), LocalDateTime.now());
            repository.save(newInfo);
        }
        return RegisterResult.success();
    }
}
