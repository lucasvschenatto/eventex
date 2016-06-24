package main.persistence.mongo;

import main.domain.Entity;
import main.domain.Repository;
import main.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class MongoRepository<TEntity extends Entity> implements Repository<TEntity> {
	private MongoCollection<Document> collection;
    private Converter<TEntity, Document> converter;

    protected MongoRepository(String collectionName, Converter<TEntity, Document> converter) {
        this.collection = getCollection(collectionName);
        this.converter = converter;
    }

    protected MongoCollection<Document> getCollection(String name) {
        MongoConnection connection = MongoConnection.getInstance();
        MongoDatabase database = connection.getDatabase();
        return database.getCollection(name);
    }

    public void save(TEntity entity) {
        if (exists(entity))
            update(entity);
        else
            insert(entity);
    }

    private boolean exists(TEntity entity) {
        return entity.hasId() && hasWithId(entity.getId());
    }

    private void update(TEntity entity) {
        Bson query = makeIdQuery(entity.getId());
        Document document = converter.to(entity);
        document.put("_id", new ObjectId(entity.getId()));
        collection.replaceOne(query, document);
    }

    private void insert(TEntity entity) {
        Document document = converter.to(entity);
        if (entity.hasId())
            document.put("_id", new ObjectId(entity.getId()));
        collection.insertOne(document);
        entity.setId(document.get("_id").toString());
    }

    public boolean hasWithId(String id) {
        try {
            return hasWith(makeIdQuery(id));
        } catch (IllegalArgumentException ignored) {
            return false;
        }
    }

    protected boolean hasWith(Bson query) {
        return collection.find(query).limit(1).first() != null;
    }

    public TEntity getById(String id) {
        return getBy(makeIdQuery(id));
    }

    protected TEntity getBy(Bson query) {
        Document document = collection.find(query).first();
        if (document == null) throw new EntityNotFoundException();
        return converter.fromPersisted(document);
    }
    
    protected Iterable<TEntity> getAllBy(Bson query){
    	List<TEntity> all = new ArrayList<>();
        for (Document document : collection.find(query))
        	all.add(converter.fromPersisted(document));
        return all;
    }

    private Bson makeIdQuery(String id) {
        return new Document("_id", new ObjectId(id));
    }

    public void deleteById(String id) {
        try {
            collection.deleteOne(makeIdQuery(id));
        } catch (IllegalArgumentException ignored) {
        }
    }

    public Iterable<TEntity> getAll() {
        List<TEntity> all = new ArrayList<>();
        for (Document document : collection.find())
            all.add(converter.fromPersisted(document));
        return all;
    }
}
