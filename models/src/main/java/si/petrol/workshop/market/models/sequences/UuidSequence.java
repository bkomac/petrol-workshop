package si.petrol.workshop.market.models.sequences;

import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.internal.databaseaccess.Accessor;
import org.eclipse.persistence.internal.sessions.AbstractSession;
import org.eclipse.persistence.sequencing.Sequence;
import org.eclipse.persistence.sessions.Session;

import java.util.UUID;
import java.util.Vector;

public class UuidSequence extends Sequence implements SessionCustomizer {

    public UuidSequence() {
        super();
    }

    public UuidSequence(String name) {
        super(name);
    }

    @Override
    public Object getGeneratedValue(Accessor accessor, AbstractSession writeSession, String seqName) {
        return UUID.randomUUID().toString();
    }

    @Override
    public Vector getGeneratedVector(Accessor accessor, AbstractSession writeSession, String seqName, int size) {
        return null;
    }

    @Override
    public void onConnect() {
    }

    @Override
    public void onDisconnect() {
    }

    @Override
    public boolean shouldAcquireValueAfterInsert() {
        return false;
    }

    @Override
    public boolean shouldUseTransaction() {
        return false;
    }

    @Override
    public boolean shouldUsePreallocation() {
        return false;
    }

    @Override
    public void customize(Session session) throws Exception {

        UuidSequence sequence = new UuidSequence("uuid");

        session.getLogin().addSequence(sequence);
    }
}
