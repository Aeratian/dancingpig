/**
 * Leader.java
 * 
 * An interface for a Leader. Contains 4 methods: one for getting
 * the current location, getting the current direction, adding
 * a follower, and removing a follower.
 * 
 * @author Ian Youn
 * @version 1.0
 * @since 11/20/2020
 */

public interface Leader 
{
    /**
     * An abstarct method for getting the current location of the Leader.
     * @return      The current location of the Leader.
     */
    public abstract Point getLocation();
    
    /**
     * An abstarct method for getting the current direction of the Leader.
     * @return      The current direction of the Leader.
     */
    public abstract Point getDirection();

    /**
     * An abstract method for adding a follower to a Leader.
     * @param pig       The DancingPig to be added as a follower.
     */
    public abstract void addFollower(DancingPig pig);

    /**
     * An abstract method for removing a follower from a Leader.
     * @param pig       The DancingPig to be removed as a follower.
     */
    public abstract void removeFollower(DancingPig pig);
}
