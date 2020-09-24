package com.example.demo.api;

import com.example.demo.domain.vo.GroupVo;
import com.example.demo.domain.vo.TraineeVo;
import com.example.demo.service.GroupService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@CrossOrigin
@RequestMapping(value = "/groups")
public class GroupController {

  private final GroupService groupService;

  public GroupController(GroupService groupService) {
    this.groupService = groupService;
  }

  @GetMapping
  public List<GroupVo> getAllGroups() {
    return groupService.findAllGroups();
  }

  @PatchMapping(path = "/{group_id}")
  public GroupVo editGroupName(@PathVariable("group_id") Long groupId, @RequestBody @Valid GroupVo groupVo) {
    return groupService.editGroupName(groupId, groupVo);
  }

}
