package podgotovkades.rest.service;

import podgotovkades.rest.exception.RemoteServiceNotAvalible;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class BackendAdapterImpl implements BackenAdapter {
    @Override
    public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback)  {

        if (simulateretry) {
            System.out.println("Simulateretry is true, so try to simulate exception scenario.");

            if (simulateretryfallback) {
                throw new RemoteServiceNotAvalible(
                        "Don't worry!! Just Simulated for Spring-retry.Must fallback as all retry will get exception!!!");
            }
            int random = new Random().nextInt(4);

            System.out.println("Random Number : " + random);
            if (random % 2 == 0) {
                throw new RemoteServiceNotAvalible("Don't worry!! Just Simulated for Spring-retry..");
            }
        }

        return "Hello from Remote Backend!!!";
    }

    @Override
    public String getBackendResponseFallback(RuntimeException e) {
        System.out.println("All retries completed, so Fallback method called!!!");
        return "All retries completed, so Fallback method called!!!";
    }
}
