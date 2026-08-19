package dev.java10x.CadastroDeFuncionaros.ui;

import dev.java10x.CadastroDeFuncionaros.dto.FuncionarioDTO;
import dev.java10x.CadastroDeFuncionaros.service.FuncionarioService;
import dev.java10x.CadastroDeFuncionaros.service.DepartamentoService; // ajuste o nome se for diferente
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/funcionarios/ui")
public class FuncionarioControllerUi {

    private final FuncionarioService funcionarioService;
    private final DepartamentoService departamentoService; // necessário para o select de departamentos

    public FuncionarioControllerUi(FuncionarioService funcionarioService,
                                   DepartamentoService departamentoService) {
        this.funcionarioService = funcionarioService;
        this.departamentoService = departamentoService;
    }

    // LISTAR
    @GetMapping("/listar")
    public String listarFuncionarios(Model model) {
        model.addAttribute("funcionarios", funcionarioService.listarFuncionarios());
        return "listarFuncionarios";
    }

    // DETALHES
    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable Long id, Model model, RedirectAttributes redirect) {
        FuncionarioDTO funcionario = funcionarioService.listarFuncionariosPorId(id);
        if (funcionario == null) {
            redirect.addFlashAttribute("erro", "Funcionário não encontrado");
            return "redirect:/funcionarios/ui/listar";
        }
        model.addAttribute("funcionario", funcionario);
        return "detalhesFuncionario";
    }

    // FORMULÁRIO DE CRIAÇÃO
    @GetMapping("/criar")
    public String formCriar(Model model) {
        model.addAttribute("funcionario", new FuncionarioDTO());
        model.addAttribute("departamentos", departamentoService.listarDepartamentos()); // ajuste o método
        model.addAttribute("titulo", "Cadastrar Funcionário");
        return "formFuncionario";
    }

    // SALVAR (CREATE)
    @PostMapping("/criar")
    public String criar(@ModelAttribute FuncionarioDTO funcionario, RedirectAttributes redirect) {
        funcionarioService.criarFuncionario(funcionario);
        redirect.addFlashAttribute("sucesso", "Funcionário criado com sucesso!");
        return "redirect:/funcionarios/ui/listar";
    }

    // FORMULÁRIO DE EDIÇÃO
    @GetMapping("/alterar/{id}")
    public String formAlterar(@PathVariable Long id, Model model, RedirectAttributes redirect) {
        FuncionarioDTO funcionario = funcionarioService.listarFuncionariosPorId(id);
        if (funcionario == null) {
            redirect.addFlashAttribute("erro", "Funcionário não encontrado");
            return "redirect:/funcionarios/ui/listar";
        }
        model.addAttribute("funcionario", funcionario);
        model.addAttribute("departamentos", departamentoService.listarDepartamentos());
        model.addAttribute("titulo", "Editar Funcionário");
        return "formFuncionario";
    }

    // ATUALIZAR
    @PostMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id,
                          @ModelAttribute FuncionarioDTO funcionario,
                          RedirectAttributes redirect) {
        FuncionarioDTO atualizado = funcionarioService.atualiarFuncionario(id, funcionario);
        if (atualizado == null) {
            redirect.addFlashAttribute("erro", "Funcionário não encontrado");
        } else {
            redirect.addFlashAttribute("sucesso", "Funcionário atualizado com sucesso!");
        }
        return "redirect:/funcionarios/ui/listar";
    }

    // DELETAR
    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirect) {
        if (funcionarioService.listarFuncionariosPorId(id) != null) {
            funcionarioService.deletarFuncionarioPorId(id);
            redirect.addFlashAttribute("sucesso", "Funcionário deletado com sucesso!");
        } else {
            redirect.addFlashAttribute("erro", "Funcionário não encontrado");
        }
        return "redirect:/funcionarios/ui/listar";
    }
}