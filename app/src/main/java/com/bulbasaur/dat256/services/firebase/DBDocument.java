package com.bulbasaur.dat256.services.firebase;

/**
 * @author ludwighultqvist
 * interface that acts as a document in the Firestore database
 */
public interface DBDocument {

    /**
     * returns the id of the document
     * @return the id string
     */
    String id();

    /**
     * gets the object of the given field. if that field or object does not exist, null
     * is returned
     * @param field the field string
     * @return the object of the field
     */
    Object get(String field);

    /**
     * gets the object of the given field.
     * @param field the field string
     * @param object the object to be saved on the field
     */
    void set(String field, Object object);

    /**
     * saves the stored objects of the fields in the Firestore database
     */
    void save();

    /**
     * deletes the document from the Firestore database
     */
    void delete();

    /**
     * returns a boolean if the document does not exist in the database
     * @return the boolean value
     */
    boolean isEmpty();

    /**
     * fetches a subCollection of the document with the name, e.g. the groups of a user etc.
     * @param name the name string
     * @return the DBCollection object
     */
    DBCollection subCollection(String name);

    void save(RequestListener listener);

    void delete(RequestListener listener);
}
