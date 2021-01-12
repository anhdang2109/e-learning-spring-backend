package com.elearning.demo.group;

import com.elearning.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImp {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> findAllGroup() { return groupRepository.findAll(); }

    public Group saveGroup(Group group) { return groupRepository.save(group); }

    public List<Group> importGroup(List<Group> groups) {
        return groupRepository.saveAll(groups);
    }

    public Group findGroupById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    public void removeGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
