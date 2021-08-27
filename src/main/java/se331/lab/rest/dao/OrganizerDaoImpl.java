package se331.lab.rest.dao;

import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(555L)
                .name("Nick")
                .address("small")
                .build());
        organizerList.add(Organizer.builder()
                .id(191L)
                .name("Hello")
                .address("world")
                .build());
        organizerList.add(Organizer.builder()
                .id(487L)
                .name("Bruh")
                .address("EZ")
                .build());
        organizerList.add(Organizer.builder()
                .id(4567L)
                .name("LG")
                .address("BTQ")
                .build());
        organizerList.add(Organizer.builder()
                .id(785L)
                .name("O")
                .address("Kay")
                .build());
        organizerList.add(Organizer.builder()
                .id(545L)
                .name("Smith")
                .address("Home")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return organizerList.subList(firstIndex,firstIndex+pageSize);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(event -> event.getId().equals(id)).findFirst().orElse(null);
    }

}


