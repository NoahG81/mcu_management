package com.project.mcu_management.domain;

import com.project.mcu_management.domain.object.Importances;
import com.project.mcu_management.domain.object.Project;
import com.project.mcu_management.domain.object.Universe;
import com.project.mcu_management.domain.object.Universes;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Component
public class ProjectUpdater {

    public Map<String, List<Project>> buildAllProjectAndSort(List<Project> projects, Universes universes) {
        Map<String, Integer> orderByCode = universes.universes().stream()
                .collect(Collectors.toMap(
                        Universe::code,
                        Universe::ordre
                ));

        Comparator<String> universeComparator =
                Comparator.comparingInt(code -> orderByCode.getOrDefault(code, Integer.MAX_VALUE));

        return projects.stream()
                .collect(Collectors.groupingBy(
                        Project::universe,
                        () -> new TreeMap<>(universeComparator),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparing(Project::ordreVisionnage))
                                        .toList())
                        ));
    }
}
