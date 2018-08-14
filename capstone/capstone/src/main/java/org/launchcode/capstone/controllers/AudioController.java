package org.launchcode.capstone.controllers;


import org.launchcode.capstone.models.Audio;
import org.launchcode.capstone.models.data.AudioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import javax.validation.Valid;

@Controller
@RequestMapping("audio")
public class AudioController {

    @Autowired
    private AudioDao audioDao;

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("audios", audioDao.findAll());
        model.addAttribute("title", "My audios");

        return "audio/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddAudioForm (Model model) {
        model.addAttribute("title", "Add Audio");
        model.addAttribute(new Audio());
        return "audio/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddAudioForm(@ModelAttribute @Valid Audio newAudio, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Audio");
            return "audio/add";
        }

        audioDao.save(newAudio);
        return "redirect:";
    }


}
