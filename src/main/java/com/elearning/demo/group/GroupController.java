package com.elearning.demo.group;


import com.elearning.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupServiceImp groupService;

    @GetMapping("/admin/groups")
    public List<Group> listGroups() {
        return groupService.findAllGroup();
    }

    @PostMapping(value = "/admin/groups/create")
    public Group saveGroup(@RequestBody Group group) {
        return groupService.saveGroup(group);
    }

    @PostMapping(value = "/admin/groups/import")
    public List<Group> importUser(@RequestBody List<Group> groups) {
        return groupService.importGroup(groups);
    }

    @GetMapping("/admin/groups/view/{id}")
    public Group viewGroup(@PathVariable(value = "id") Long id) {
        return groupService.findGroupById(id);
    }

    @GetMapping("/admin/groups/edit/{id}")
    public Group showEditForm(@PathVariable(value = "id") Long id) {
        return groupService.findGroupById(id);
    }

    @PutMapping("/admin/groups/edit")
    public Group updateGroup(@RequestBody Group group) {
        return groupService.saveGroup(group);
    }

    @DeleteMapping ("/admin/groups/delete/{id}")
    public void deleteGroup(@PathVariable(value = "id") Long id) {
        groupService.removeGroup(id);
    }

}
