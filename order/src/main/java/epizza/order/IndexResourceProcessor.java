package epizza.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
public class IndexResourceProcessor implements ResourceProcessor<RepositoryLinksResource> {

    private final EntityLinks entityLinks;

    @Autowired
    public IndexResourceProcessor(EntityLinks entityLinks) {
        this.entityLinks = entityLinks;
    }

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource resource) {
        resource.add(entityLinks.linkToCollectionResource(Order.class));
        return resource;
    }

}
