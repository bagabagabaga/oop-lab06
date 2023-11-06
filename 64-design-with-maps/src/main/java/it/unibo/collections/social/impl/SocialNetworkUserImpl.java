/**
 * 
 */
package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:  think of what type of keys and values would best suit the requirements
     */
    HashMap<String, Collection<U>> followeUserMap;
    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */
    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        followeUserMap = new HashMap<String, Collection<U>>();
    }
    /*
     * 2) Define a further constructor where the age defaults to -1
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user);
        followeUserMap = new HashMap<String, Collection<U>>();
    }
    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        Collection<U> userSet = followeUserMap.get(circle); /* Get the old list */
        if(userSet == null){
            userSet = new HashSet<U>();
        }
        boolean userNotFollowed = userSet.add(user); /* Update the list */
        if(userNotFollowed){
            followeUserMap.put(circle, userSet);
        }
        return userNotFollowed;
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        if(followeUserMap.containsKey(groupName)){
            Collection<U> tmp = new HashSet<U>();
            for(U user : followeUserMap.get(groupName)){
                tmp.add(user);
            }
            return tmp;
        }
        return new HashSet<U>();
    }

    @Override
    public List<U> getFollowedUsers() {
        List<U> everyFollowedUser = new ArrayList<U>();
        for(Collection<U> userCollection : followeUserMap.values()){
            everyFollowedUser.addAll(userCollection);
        }
        return everyFollowedUser;
    }
}
