package com.buddhapps.globalsanghaback.service;

import com.buddhapps.globalsanghaback.model.Tool;
import com.buddhapps.globalsanghaback.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    public Tool createTool(Tool tool) {
        return toolRepository.save(tool);
    }

    public List<Tool> getAllTools() {
        return toolRepository.findAll();
    }

    public Tool getToolById(Long id) {
        return toolRepository.findById(id).orElse(null);
    }

    public Tool updateTool(Long id, Tool toolDetails) {
        Tool tool = toolRepository.findById(id).orElse(null);
        if (tool != null) {
            tool.setName(toolDetails.getName());
            tool.setDescription(toolDetails.getDescription());
            tool.setAvailable(toolDetails.getAvailable());
            tool.setStatus(toolDetails.getStatus());
            // Asegúrate de incluir cualquier otro campo que necesites actualizar
            return toolRepository.save(tool);
        }
        return null;
    }

    public void deleteTool(Long id) {
        toolRepository.deleteById(id);
    }
}
