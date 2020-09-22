import { UIServiceRegister } from '@/uiservice/ui-service-register';
import { AuthServiceRegister } from '@/authservice/auth-service-register';
import { UtilServiceRegister } from '@/utilservice/util-service-register';
import { EntityServiceRegister } from '@/service/entity-service-register';
import { CounterServiceRegister } from '@/counter/counter-service-register';
import { CodeListRegister } from '@codelist/codelist-register';
import { MessageServiceRegister } from '@/message/message-service-register';
declare global {
    interface Window {
        uiServiceRegister: UIServiceRegister,
        authServiceRegister: AuthServiceRegister,
        utilServiceRegister: UtilServiceRegister,
        entityServiceRegister: EntityServiceRegister,
        counterServiceRegister: CounterServiceRegister,
        codeListRegister:CodeListRegister,
        messageServiceRegister:MessageServiceRegister
    }
}