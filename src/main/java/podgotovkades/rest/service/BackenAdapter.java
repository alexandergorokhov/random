package podgotovkades.rest.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import podgotovkades.rest.exception.RemoteServiceNotAvalible;


public interface BackenAdapter {

    @Retryable(value = {RemoteServiceNotAvalible.class}, maxAttempts = 5, backoff = @Backoff(delay = 1000))
    public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback);

    @Recover
    public String getBackendResponseFallback(RuntimeException e);
}
