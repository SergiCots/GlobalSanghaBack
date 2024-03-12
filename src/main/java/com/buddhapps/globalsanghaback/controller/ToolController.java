package com.buddhapps.globalsanghaback.controller;

import com.buddhapps.globalsanghaback.model.Tool;
import com.buddhapps.globalsanghaback.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tools")
public class ToolController {

    @Autowired
    private ToolService toolService;

    @PostMapping("/")
    public ResponseEntity<Boolean> createTool(@RequestBody Tool tool) {
        Tool toolSaved = toolService.createTool(tool);
        if (toolSaved!= null) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        }
    }


    @GetMapping("/")
    public List<Tool> getAllTools() {
        return toolService.getAllTools();
    }

    @GetMapping("/user/{id}")
    public List<Tool> getToolByUser(@PathVariable Long id) {
        return toolService.getToolsByUser(id);
    }

    @GetMapping("/{id}")
    public Tool getToolById(@PathVariable Long id) {
        return toolService.getToolById(id);
    }

    @PutMapping("/{id}")
    public Tool updateTool(@PathVariable Long id, @RequestBody Tool toolDetails) {
        return toolService.updateTool(id, toolDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTool(@PathVariable Long id) {
        toolService.deleteTool(id);
        return ResponseEntity.ok().build();
    }
}
