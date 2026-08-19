package dev.java10x.CadastroDeFuncionaros.ui;

import dev.java10x.CadastroDeFuncionaros.dto.DepartamentoDTO;
import dev.java10x.CadastroDeFuncionaros.service.DepartamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/departamento/ui")
public class DepartamentoControllerUi {

    private final DepartamentoService departamentoService;

    public DepartamentoControllerUi(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    // LISTAR
    @GetMapping("/listar")
    public String listarDepartamentos(Model model) {
        model.addAttribute("departamentos", departamentoService.listarDepartamentos());
        return "listarDepartamentos";
    }

    // DETALHES
    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable Long id, Model model, RedirectAttributes redirect) {
        DepartamentoDTO departamento = departamentoService.listarDepartamentosPorId(id);
        if (departamento == null) {
            redirect.addFlashAttribute("erro", "Departamento não encontrado");
            return "redirect:/departamento/ui/listar";
        }
        model.addAttribute("departamento", departamento);
        return "detalhesDepartamento";
    }

    // FORMULÁRIO DE CRIAÇÃO
    @GetMapping("/criar")
    public String formCriar(Model model) {
        model.addAttribute("departamento", new DepartamentoDTO());
        model.addAttribute("titulo", "Cadastrar Departamento");
        return "detalhesDepartamento";
    }

    // SALVAR (CREATE)
    @PostMapping("/criar")
    public String criar(@ModelAttribute DepartamentoDTO departamento, RedirectAttributes redirect) {
        departamentoService.criarDepartamento(departamento);
        redirect.addFlashAttribute("sucesso", "Departamento criado com sucesso!");
        return "redirect:/departamento/ui/listar";
    }

    // FORMULÁRIO DE EDIÇÃO
    @GetMapping("/alterar/{id}")
    public String formAlterar(@PathVariable Long id, Model model, RedirectAttributes redirect) {
        DepartamentoDTO departamento = departamentoService.listarDepartamentosPorId(id);
        if (departamento == null) {
            redirect.addFlashAttribute("erro", "Departamento não encontrado");
            return "redirect:/departamento/ui/listar";
        }
        model.addAttribute("departamento", departamento);
        model.addAttribute("titulo", "Editar Departamento");
        return "detalhesDepartamento";
    }

    // ATUALIZAR
    @PostMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id,
                          @ModelAttribute DepartamentoDTO departamento,
                          RedirectAttributes redirect) {
        DepartamentoDTO atualizado = departamentoService.atualizarDepartamento(id, departamento);
        if (atualizado == null) {
            redirect.addFlashAttribute("erro", "Departamento não encontrado");
        } else {
            redirect.addFlashAttribute("sucesso", "Departamento atualizado com sucesso!");
        }
        return "redirect:/departamento/ui/listar";
    }

    // DELETAR
    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirect) {
        if (departamentoService.listarDepartamentosPorId(id) != null) {
            departamentoService.deletarDepartamentoPorId(id);
            redirect.addFlashAttribute("sucesso", "Departamento deletado com sucesso!");
        } else {
            redirect.addFlashAttribute("erro", "Departamento não encontrado");
        }
        return "redirect:/departamento/ui/listar";
    }
}