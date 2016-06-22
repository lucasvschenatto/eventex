package main.persistence.mongo;

public interface Converter<TDomain, TPersisted> {
    TPersisted to(TDomain value);
    TDomain fromPersisted(TPersisted value);
    @SuppressWarnings("unchecked")
	default TDomain from(Object value) {
        return this.fromPersisted((TPersisted) value);
    }
}
