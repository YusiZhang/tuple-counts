package michaelrkytch.tuple_counts;

import java.sql.Timestamp;
import java.util.Map;

public interface CountSummary {

    public static interface CountPair {
        long getCount();
        Timestamp getTime();
    }

    public static interface ActionsSummary 
    extends Map<Object, Map<Object, CountPair >> {}

    /**
     * @return the count summary for a given tuple key.
     */
    CountPair getCount(Object subj, Object action, Object obj);
    
    /**
     * Return all interaction records between the given subject and all 
     * other objects, grouped by action.
     * Subtree is of the form { action { object [count timestamp] } }
     */
    ActionsSummary recordsByInteraction(Object subj);
    
    /**
     * Return all interactions between the given subject and all other objects,
     * grouped by action, and sorted by count within each action.
     * @return { action { object [count timestamp] } }, where the records of {obj [count timestamp]} 
     * are sorted by descending count.
     */
    Map<Object, Map<Object, Double>>sortedCounts(Object subj);
    
    /**
     * Sum all event counts for one subject
     */
    long sumCounts(Object subj);
    
    /**
     * For a given subject,<br>sum all event counts for a set of actions
     */
    long sumCounts(Object subj, Object... actions);
}
