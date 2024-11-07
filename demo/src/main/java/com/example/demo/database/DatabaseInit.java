package com.example.demo.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.model.Administrador;
import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;
import com.example.demo.model.Role;
import com.example.demo.model.Veterinario;
import com.example.demo.model.Droga;
import com.example.demo.model.Tratamiento;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.AdministradorRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.DrogaRepository;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.TratamientoRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VeterinarioRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
@Profile("default")
public class DatabaseInit implements ApplicationRunner{

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MascotaRepository mascotaRepository;


    @Autowired
    VeterinarioRepository veterinarioRepository;

    @Autowired
    AdministradorRepository administradorRepository;

    @Autowired
    DrogaRepository drogaRepository;

    
    @Autowired
    TratamientoRepository tratamientoRepository;


    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    RoleRepository roleRepository;


    @Autowired
    UserRepository userRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {


        roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("CLIENTE"));
        roleRepository.save(new Role("VETERINARIO"));

        Administrador adminSave;
        Cliente clienteSave;
        Veterinario veterinarioSave;
        UserEntity userEntity;

        adminSave = Administrador.builder().cedula("123456").nombre("Daniel Teran").correo("daniel_teran@example.com").password("0000").build();
        userEntity = saveUserAdmin(adminSave);
        adminSave.setUser(userEntity);
        administradorRepository.save(adminSave);

        //Agregar clientes a la base de datos
        clienteSave = Cliente.builder().cedula("001").nombre("Ana Gómez").correo("ana.gomez@example.com").celular("3000000001").foto("https://randomuser.me/api/portraits/women/1.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("002").nombre("Carlos García").correo("carlos.garcia@example.com").celular("3000000002").foto("https://randomuser.me/api/portraits/men/2.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("003").nombre("Laura Fernández").correo("laura.fernandez@example.com").celular("3000000003").foto("https://randomuser.me/api/portraits/women/2.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("004").nombre("José Rodríguez").correo("jose.rodriguez@example.com").celular("3000000004").foto("https://randomuser.me/api/portraits/men/2.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("005").nombre("Isabel Sánchez").correo("isabel.sanchez@example.com").celular("3000000005").foto("https://randomuser.me/api/portraits/women/3.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("006").nombre("Luis Pérez").correo("luis.perez@example.com").celular("3000000006").foto("https://randomuser.me/api/portraits/men/3.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("007").nombre("Sofia Torres").correo("sofia.torres@example.com").celular("3000000007").foto("https://randomuser.me/api/portraits/women/4.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("008").nombre("Antonio López").correo("antonio.lopez@example.com").celular("3000000008").foto("https://randomuser.me/api/portraits/men/4.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("009").nombre("Carla Martínez").correo("carla.martinez@example.com").celular("3000000009").foto("https://randomuser.me/api/portraits/women/5.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("010").nombre("Francisco Gómez").correo("francisco.gomez@example.com").celular("3000000010").foto("https://randomuser.me/api/portraits/men/5.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("011").nombre("Raquel González").correo("raquel.gonzalez@example.com").celular("3000000011").foto("https://randomuser.me/api/portraits/women/6.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("012").nombre("Javier Fernández").correo("javier.fernandez@example.com").celular("3000000012").foto("https://randomuser.me/api/portraits/men/6.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("013").nombre("Marta Pérez").correo("marta.perez@example.com").celular("3000000013").foto("https://randomuser.me/api/portraits/women/7.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("014").nombre("Manuel Díaz").correo("manuel.diaz@example.com").celular("3000000014").foto("https://randomuser.me/api/portraits/men/7.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("015").nombre("Carmen López").correo("carmen.lopez@example.com").celular("3000000015").foto("https://randomuser.me/api/portraits/women/8.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("016").nombre("Carlos Morales").correo("carlos.morales@example.com").celular("3000000016").foto("https://randomuser.me/api/portraits/men/8.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("017").nombre("Beatriz Martínez").correo("beatriz.martinez@example.com").celular("3000000017").foto("https://randomuser.me/api/portraits/women/9.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("018").nombre("Fernando Romero").correo("fernando.romero@example.com").celular("3000000018").foto("https://randomuser.me/api/portraits/men/9.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("019").nombre("Elena Rodríguez").correo("elena.rodriguez@example.com").celular("3000000019").foto("https://randomuser.me/api/portraits/women/10.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("020").nombre("Sergio García").correo("sergio.garcia@example.com").celular("3000000020").foto("https://randomuser.me/api/portraits/men/10.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("021").nombre("Gabriela Fernández").correo("gabriela.fernandez@example.com").celular("3000000021").foto("https://randomuser.me/api/portraits/women/11.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("022").nombre("David Fernández").correo("david.fernandez@example.com").celular("3000000022").foto("https://randomuser.me/api/portraits/men/11.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("023").nombre("Victoria Pérez").correo("victoria.perez@example.com").celular("3000000023").foto("https://randomuser.me/api/portraits/women/12.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("024").nombre("Miguel Álvarez").correo("miguel.alvarez@example.com").celular("3000000024").foto("https://randomuser.me/api/portraits/men/12.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("025").nombre("Luz García").correo("luz.garcia@example.com").celular("3000000025").foto("https://randomuser.me/api/portraits/women/13.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("026").nombre("José Sánchez").correo("jose.sanchez@example.com").celular("3000000026").foto("https://randomuser.me/api/portraits/men/13.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("027").nombre("Valeria Ruiz").correo("valeria.ruiz@example.com").celular("3000000027").foto("https://randomuser.me/api/portraits/women/14.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("028").nombre("Arturo Pérez").correo("arturo.perez@example.com").celular("3000000028").foto("https://randomuser.me/api/portraits/men/14.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("029").nombre("Teresa López").correo("teresa.lopez@example.com").celular("3000000029").foto("https://randomuser.me/api/portraits/women/15.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("030").nombre("Andrés Gómez").correo("andres.gomez@example.com").celular("3000000030").foto("https://randomuser.me/api/portraits/men/15.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("031").nombre("Paola Ramírez").correo("paola.ramirez@example.com").celular("3000000031").foto("https://randomuser.me/api/portraits/women/16.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("032").nombre("Felipe Jiménez").correo("felipe.jimenez@example.com").celular("3000000032").foto("https://randomuser.me/api/portraits/men/16.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("033").nombre("Nancy Torres").correo("nancy.torres@example.com").celular("3000000033").foto("https://randomuser.me/api/portraits/women/17.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("034").nombre("Guillermo Rivera").correo("guillermo.rivera@example.com").celular("3000000034").foto("https://randomuser.me/api/portraits/men/17.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("035").nombre("Daniela Herrera").correo("daniela.herrera@example.com").celular("3000000035").foto("https://randomuser.me/api/portraits/women/18.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("036").nombre("Raul Vargas").correo("raul.vargas@example.com").celular("3000000036").foto("https://randomuser.me/api/portraits/men/18.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("037").nombre("Lucia Ortiz").correo("lucia.ortiz@example.com").celular("3000000037").foto("https://randomuser.me/api/portraits/women/19.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("038").nombre("Pablo Morales").correo("pablo.morales@example.com").celular("3000000038").foto("https://randomuser.me/api/portraits/men/19.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("039").nombre("Marina Flores").correo("marina.flores@example.com").celular("3000000039").foto("https://randomuser.me/api/portraits/women/20.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("040").nombre("Samuel Castillo").correo("samuel.castillo@example.com").celular("3000000040").foto("https://randomuser.me/api/portraits/men/20.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("041").nombre("Monica Reyes").correo("monica.reyes@example.com").celular("3000000041").foto("https://randomuser.me/api/portraits/women/21.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("042").nombre("Hector Martinez").correo("hector.martinez@example.com").celular("3000000042").foto("https://randomuser.me/api/portraits/men/21.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("043").nombre("Ana Campos").correo("ana.campos@example.com").celular("3000000043").foto("https://randomuser.me/api/portraits/women/22.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("044").nombre("Cristian Medina").correo("cristian.medina@example.com").celular("3000000044").foto("https://randomuser.me/api/portraits/men/22.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("045").nombre("Patricia Salazar").correo("patricia.salazar@example.com").celular("3000000045").foto("https://randomuser.me/api/portraits/women/23.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("046").nombre("Rodrigo Guzman").correo("rodrigo.guzman@example.com").celular("3000000046").foto("https://randomuser.me/api/portraits/men/23.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("047").nombre("Silvia Rios").correo("silvia.rios@example.com").celular("3000000047").foto("https://randomuser.me/api/portraits/women/24.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("048").nombre("Emilio Suarez").correo("emilio.suarez@example.com").celular("3000000048").foto("https://randomuser.me/api/portraits/men/24.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("049").nombre("Gloria Mendez").correo("gloria.mendez@example.com").celular("3000000049").foto("https://randomuser.me/api/portraits/women/25.jpg").build();
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = Cliente.builder().cedula("050").nombre("Adrian Diaz").correo("adrian.diaz@example.com").celular("3000000050").foto("https://randomuser.me/api/portraits/men/25.jpg").build();


        
        // Agregar mascotas a la base de datos
        mascotaRepository.save(new Mascota("Misu", "Persa", 3, 4.2, "Asma", "https://static.nationalgeographicla.com/files/styles/image_3200/public/nationalgeographic_1468962.jpg?w=1900&h=1400", true));
        mascotaRepository.save(new Mascota("Gatito", "Siamés", 2, 3.8, "Alergia", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7Rsfl6dIGPbojoNrUPdja0WjgGk8ESACRZg&s", false));
        mascotaRepository.save(new Mascota("Nube", "Maine Coon", 4, 5.5, "Obesidad", "https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1900&h=1267", true));
        mascotaRepository.save(new Mascota("Luna", "Bengala", 1, 3.0, "Conjuntivitis", "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/GettyImages-623368750-e1582816063521-1.jpg", false));
        mascotaRepository.save(new Mascota("Felix", "Británico de pelo corto", 5, 4.8, "Artritis", "https://www.mirringo.com.co/Portals/mirringo/Images/articulos-actualidad-gatuna/ciclo-de-vida-de-los-gatos/Interna-1-ciclo-de-vida-de-los-gatos.jpg?ver=2024-03-20-160432-910", true));
        mascotaRepository.save(new Mascota("Salem", "Esfinge", 2, 3.5, "Dermatitis", "https://urgenciesveterinaries.com/wp-content/uploads/2023/09/survet-gato-caida-pelo-01.jpeg", false));
        mascotaRepository.save(new Mascota("Tom", "Azul ruso", 4, 4.3, "Problemas dentales", "https://images.ctfassets.net/denf86kkcx7r/4IPlg4Qazd4sFRuCUHIJ1T/f6c71da7eec727babcd554d843a528b8/gatocomuneuropeo-97", true));
        mascotaRepository.save(new Mascota("Milo", "Chartreux", 3, 3.9, "Infección urinaria", "https://static.nationalgeographic.es/files/styles/image_3200/public/01-cat-groom-nationalgeographic-1031934.jpg?w=1600", false));
        mascotaRepository.save(new Mascota("Simba", "Abisinio", 2, 4.0, "Inmunodeficiencia felina", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFfYvvtpTzrBYEKzjEzJH8lWbS1ab2pjeiAA&s", true));
        mascotaRepository.save(new Mascota("Coco", "Ragdoll", 1, 4.5, "Parásitos", "https://greentology.life/wp-content/uploads/2023/11/gatos_adorable-gatito-gafas-sol.jpg", false));
        mascotaRepository.save(new Mascota("Oreo", "Gato doméstico", 2, 4.0, "Obesidad", "https://fotografias.lasexta.com/clipping/cmsimages02/2019/01/25/DB41B993-B4C4-4E95-8B01-C445B8544E8E/98.jpg?crop=4156,2338,x0,y219&width=1900&height=1069&optimize=high&format=webply", true));
        mascotaRepository.save(new Mascota("Mittens", "Siberiano", 3, 5.0, "Infección respiratoria", "https://upload.wikimedia.org/wikipedia/commons/4/46/Zuri.jpg", false));
        mascotaRepository.save(new Mascota("Pinky", "Himalayo", 4, 4.6, "Problemas de piel", "https://www.zooplus.es/magazine/wp-content/uploads/2022/01/Psicologia-felina.jpeg", true));
        mascotaRepository.save(new Mascota("Oscar", "Norwegian Forest", 5, 5.2, "Diarrea", "https://media.es.wired.com/photos/657cb5b81e17b099f8f9e15c/16:9/w_3008,h_1692,c_limit/gatos%20172050389.jpg", false));
        mascotaRepository.save(new Mascota("Bella", "Abisinio", 1, 3.4, "Inmunodeficiencia felina", "https://www.clinicaveterinariazarpa.com/wp-content/uploads/2024/01/zarpa-blog.jpg", true));
        mascotaRepository.save(new Mascota("Cleo", "Bengala", 2, 4.1, "Alergia alimentaria", "https://static.nationalgeographicla.com/files/styles/image_3200/public/01-cat-questions-nationalgeographic_1228126.jpg?w=1600&h=900", false));
        mascotaRepository.save(new Mascota("Max", "Británico de pelo corto", 3, 4.0, "Problemas cardíacos", "https://purina.com.co/sites/default/files/styles/webp/public/2022-10/purina-10-datos-curiosos-sobre-los-gatos.png.webp?itok=3B4Lm7-f", true));
        mascotaRepository.save(new Mascota("Lily", "Siamés", 2, 3.8, "Alergia", "https://www.hola.com/horizon/square/ee725cadf31b-gatos-caseros-t.jpg", false));
        mascotaRepository.save(new Mascota("Nina", "Gato de pelo largo", 1, 4.3, "Parásitos", "https://www.ngenespanol.com/wp-content/uploads/2024/02/estas-son-las-razas-de-gatos-que-viven-mas-1280x720.jpg", true));
        mascotaRepository.save(new Mascota("Maggie", "Sphynx", 3, 4.0, "Dermatitis", "https://s1.elespanol.com/2023/03/10/curiosidades/mascotas/747436034_231551833_854x640.jpg", false));
        mascotaRepository.save(new Mascota("Toby", "Manx", 4, 5.1, "Problemas digestivos", "https://cdn.royalcanin-weshare-online.io/GlbQCHwBBKJuub5qnL9Z/v5/bp-lot-3-american-bobtail-davinci", true));
        mascotaRepository.save(new Mascota("Zara", "Scottish Fold", 5, 4.7, "Diarrea", "https://www.whiskas.cl/cdn-cgi/image/height=617,f=auto,quality=90/sites/g/files/fnmzdf4541/files/2023-11/elever-un-Chaton-ses-premiers-mois.jpg", false));
        mascotaRepository.save(new Mascota("Buddy", "Cornish Rex", 2, 3.9, "Problemas respiratorios", "https://www.marthadebayle.com/wp-content/uploads/2023/06/de-donde-vienen-los-gatos.jpg", true));
        mascotaRepository.save(new Mascota("Misty", "Burmese", 3, 4.4, "Problemas dentales", "https://s1.ppllstatics.com/lasprovincias/www/multimedia/202112/12/media/cortadas/gatos-kb2-U160232243326NVC-1248x770@Las%20Provincias.jpg", false));
        mascotaRepository.save(new Mascota("Paws", "Oriental", 4, 3.8, "Enfermedad hepática", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/220px-Cat_November_2010-1a.jpg", true));
        mascotaRepository.save(new Mascota("Whiskers", "Singapura", 1, 4.0, "Obesidad", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSA0sgWEbLlrrbm2qrM7I4xbHo2LGMnMuUIvQ&s", false));
        mascotaRepository.save(new Mascota("Charlie", "Selkirk Rex", 2, 3.7, "Alergia", "https://www.elespectador.com/resizer/GtLezpDdZTdlwNqHVM1C0zSafJw=/arc-anglerfish-arc2-prod-elespectador/public/BOP5BVFGYBDMDK4J5B7YQ3VOUM.jpg", true));
        mascotaRepository.save(new Mascota("Sasha", "Turco Van", 3, 4.2, "Problemas digestivos", "https://www.veterinariaargosalbacete.com/wp-content/uploads/2020/12/mi-gato-pierde-mucho-pelo.jpg", false));
        mascotaRepository.save(new Mascota("Oliver", "Ragdoll", 4, 4.5, "Parásitos", "https://img2.rtve.es/i/?w=1600&i=1618587961630.jpg", true));
        mascotaRepository.save(new Mascota("Luna", "Somalí", 5, 5.0, "Problemas respiratorios", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgWOCLVV0wRNYlUPGDb-3RZto74mTVl55NMA&s", false));
        mascotaRepository.save(new Mascota("Daisy", "Maine Coon", 1, 5.3, "Obesidad", "https://puppis.blog/wp-content/uploads/2022/02/abc-cuidado-de-los-gatos-min.jpg", true));
        mascotaRepository.save(new Mascota("Simba", "Bengala", 2, 4.2, "Inmunodeficiencia felina", "https://cdn.prod.website-files.com/63634f4a7b868a399577cf37/63e10bf28752f848463155b3_razas%20de%20gatos.jpg", false));
        mascotaRepository.save(new Mascota("Lola", "Bengala", 3, 4.1, "Problemas dentales", "https://ichef.bbci.co.uk/ace/ws/640/cpsprodpb/10E9B/production/_109757296_gettyimages-1128004359.jpg.webp", true));
        mascotaRepository.save(new Mascota("Leo", "Siamés", 4, 3.8, "Problemas de piel", "https://estaticos-cdn.prensaiberica.es/clip/4e1211c1-1520-41a7-aabb-42c2e03d1731_alta-libre-aspect-ratio_default_0.jpg", false));
        mascotaRepository.save(new Mascota("Kiki", "Siamés", 5, 3.9, "Alergia alimentaria", "https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos-635x358.jpg", true));
        mascotaRepository.save(new Mascota("Trixie", "Británico de pelo corto", 1, 4.0, "Artritis", "https://imagenes.eltiempo.com/files/image_1200_600/uploads/2023/03/13/640f76f75c8c7.jpeg", false));
        mascotaRepository.save(new Mascota("Fiona", "British Shorthair", 2, 4.2, "Obesidad", "https://www.cadenadial.com/wp-content/uploads/2021/10/GettyImages-1302471279-1-1-scaled-e1649764781524.jpg", true));
        mascotaRepository.save(new Mascota("Tommy", "Maine Coon", 3, 5.5, "Infección respiratoria", "https://parcerosfelinos.com/wp-content/uploads/2022/06/La-flexibilidad-y-agilidad-de-los-gatos-1024x576.jpg", false));
        mascotaRepository.save(new Mascota("Coco", "Maine Coon", 4, 5.4, "Diarrea", "https://imagenes.20minutos.es/files/image_1920_1080/uploads/imagenes/2023/08/22/gato-esfinge-sphynx-dmitri-makeev-wikimedia-commons-cc-by-sa-4-0.jpeg", true));
        mascotaRepository.save(new Mascota("Lucy", "Turco Van", 5, 4.1, "Alergia alimentaria", "https://www.ngenespanol.com/wp-content/uploads/2023/06/gatos-nariz-1280x720.jpeg", false));
        mascotaRepository.save(new Mascota("Rex", "Sphynx", 1, 3.7, "Problemas respiratorios", "https://dovet.es/wp-content/uploads/2017/01/gato-768x658.jpg", true));
        mascotaRepository.save(new Mascota("Lilly", "Sphynx", 2, 3.9, "Parásitos", "https://media.admagazine.com/photos/618a65c8e702c61c265bbcef/master/w_1600%2Cc_limit/73996.jpg", false));
        mascotaRepository.save(new Mascota("Charlie", "Scottish Fold", 3, 4.0, "Problemas dentales", "https://static.fundacion-affinity.org/cdn/farfuture/46mZnLhAYw8xwZBGnHdtITnaZqhrx5cvHSN81eUMWzw/mtime:1528830293/sites/default/files/el-gato-necesita-tener-acceso-al-exterior.jpg", true));
        mascotaRepository.save(new Mascota("Milo", "Scottish Fold", 4, 3.8, "Inmunodeficiencia felina", "https://clinicaveterinarium.es/wp-content/uploads/2023/11/lindo-gatito-gato-siames-interior.jpg", false));
        mascotaRepository.save(new Mascota("Toby", "Singapura", 5, 4.2, "Enfermedad hepática", "https://www.zooplus.es/magazine/wp-content/uploads/2018/11/fotolia_122422577-768x576.jpg", true));
        mascotaRepository.save(new Mascota("Bella", "Singapura", 1, 4.3, "Problemas digestivos", "https://cdn.nubika.es/wp-content/uploads/2023/11/12151442/manias-gatos.jpg", false));
        mascotaRepository.save(new Mascota("Paws", "Oriental", 2, 4.1, "Problemas respiratorios", "https://s1.elespanol.com/2020/11/16/curiosidades/mascotas/mascotas-gatos-plantas_536457166_165216701_1706x960.jpg", true));
        mascotaRepository.save(new Mascota("Ginger", "Siamés", 3, 3.6, "Alergia alimentaria", "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/el-celo-en-los-gatos-1.jpg?w=1024", false));
        mascotaRepository.save(new Mascota("Luna", "Siamés", 4, 3.8, "Obesidad", "https://www.laalergia.com/sites/reactine_es/files/files/header-images/shutterstock_1007849866_1_gatos1.jpg", true));
        mascotaRepository.save(new Mascota("Whiskers", "Ragdoll", 5, 4.0, "Alergia", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbAFikj08RaTh0rrq0bz38GGks5jimSJE5Qg&s", false));
        mascotaRepository.save(new Mascota("Luna", "Persa", 3, 4.0, "Alergia", "https://imagenes.eltiempo.com/files/image_1200_600/uploads/2023/02/07/63e2e8ab9eda8.jpeg", true));
        mascotaRepository.save(new Mascota("Lola", "Siamés", 2, 3.5, "Asma", "https://content.elmueble.com/medio/2023/04/14/gato-de-raza-ragdoll_5c5827ec_230414185205_1000x1493.jpg", false));
        mascotaRepository.save(new Mascota("Maggie", "Maine Coon", 4, 5.1, "Conjuntivitis", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTB0c_EPB9CwcFXEDhfoe3gMcX2xawCOu1Hyw&s", true));
        mascotaRepository.save(new Mascota("Charlie", "Sphynx", 1, 4.2, "Dermatitis", "https://t2.uc.ltmcdn.com/es/posts/8/4/6/cuales_son_los_gatos_mas_tranquilos_33648_600.webp", true));
        mascotaRepository.save(new Mascota("Felix", "Bengala", 5, 4.4, "Infección respiratoria", "https://www.tiendanimal.es/articulos/wp-content/uploads/2018/01/mitos-sobre-gatos-1200x900.jpg", false));
        mascotaRepository.save(new Mascota("Oscar", "Scottish Fold", 3, 4.1, "Problemas dentales", "https://imagenes.heraldo.es/files/image_1920_1080/uploads/imagenes/2024/01/26/gatito-gato-gsc1.jpeg", true));
        mascotaRepository.save(new Mascota("Ginger", "Siamés", 2, 3.7, "Parásitos", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqd0wOkN4enR8kBYhBauFqJE-lWCfQxtULtw&s", false));
        mascotaRepository.save(new Mascota("Milo", "Maine Coon", 4, 5.3, "Diarrea", "https://www.clarin.com/2012/02/04/BJbM2IRnQg_1200x0.jpg", true));
        mascotaRepository.save(new Mascota("Nina", "Bengala", 1, 4.0, "Problemas digestivos", "https://e00-elmundo.uecdn.es/assets/multimedia/imagenes/2023/12/12/17023776436291.jpg", false));
        mascotaRepository.save(new Mascota("Sasha", "Sphynx", 3, 4.2, "Problemas respiratorios", "https://ichef.bbci.co.uk/ace/ws/640/cpsprodpb/18504/production/_90488599_thinkstockphotos_gato6.jpg.webp", true));
        mascotaRepository.save(new Mascota("Luna", "Turco Van", 2, 4.5, "Conjuntivitis", "https://cdn.royalcanin-weshare-online.io/fyI_PmYBaxEApS7LyAb0/v1/ec36h-is-your-cat-stressed-hero-cat", false));
        mascotaRepository.save(new Mascota("Bella", "Siamés", 4, 3.8, "Artritis", "https://vitakraft.es/wp-content/uploads/2022/05/Blog_ColaGatos-1110x600.jpg", true));
        mascotaRepository.save(new Mascota("Simba", "Sphynx", 1, 3.9, "Obesidad", "https://purina.com.uy/sites/default/files/styles/webp/public/2022-10/conoce-por-que-no-es-buena-idea-usar-un-disfraz-para-tu-gato-desktop.png.webp?itok=pa7TzVHV", false));
        mascotaRepository.save(new Mascota("Ginger", "Maine Coon", 2, 5.0, "Problemas dentales", "https://www.elespectador.com/resizer/v2/LKMDZKHDHVE75GCRD5XPBUKHCY.png?auth=d67de540966cff25edba7ada9da45a77a1d027404c50f8ee20c387e5f1d8e441&width=920&height=613&smart=true&quality=60", true));
        mascotaRepository.save(new Mascota("Daisy", "Bengala", 3, 4.3, "Alergia", "https://estaticos-cdn.prensaiberica.es/clip/132634e7-ba6a-4ea6-b531-f0377b7a9eba_alta-libre-aspect-ratio_default_0.jpg", false));
        mascotaRepository.save(new Mascota("Max", "Persa", 4, 4.1, "Problemas digestivos", "https://images.ctfassets.net/ozvjkvyngwhv/7XI7Nz6LVrBPN8PqHFOGg/1837c9f22f7b95bc0001d4dec4d5b70e/1024-X-300-IMG-BLOG-CAIDA-DEL-PELO-DE-TU-PELUDO-__1_.jpg", true));
        mascotaRepository.save(new Mascota("Cleo", "Scottish Fold", 2, 4.2, "Infección respiratoria", "https://static.eldiario.es/clip/ab74aa95-3656-424c-8ca1-dce590aabb97_16-9-discover-aspect-ratio_default_0.jpg", false));
        mascotaRepository.save(new Mascota("Whiskers", "Sphynx", 5, 3.9, "Problemas de piel", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTPlwn347GKEW5rFh5y34Ow_epRu4bqNXFTA&s", true));
        mascotaRepository.save(new Mascota("Lucy", "Maine Coon", 3, 5.4, "Alergia alimentaria", "https://vitakraft.es/wp-content/uploads/2020/06/imagen_gato_cachorro_1920x1280-1110x600.jpg", false));
        mascotaRepository.save(new Mascota("Toby", "Bengala", 1, 4.0, "Problemas respiratorios", "https://okdiario.com/img/2020/07/25/curiosidades-sobre-la-inteligencia-de-los-gatos-635x358.jpg", true));
        mascotaRepository.save(new Mascota("Coco", "Siamés", 2, 4.5, "Artritis", "https://resizer.glanacion.com/resizer/v2/un-experto-recomendo-con-que-gatos-no-hay-que-4WWGJ4UZUNC6PIMTJ7UEII2WAA.jpg?auth=fe8ee5dd7cd5bbc7e39915c95ecfebae17d1e3305e95f232afeaea5dffc4b121&width=880&height=586&quality=70&smart=true", false));
        mascotaRepository.save(new Mascota("Paws", "Scottish Fold", 4, 3.7, "Conjuntivitis", "https://www.aon.es/personales/seguro-perro-gato/wp-content/uploads/sites/2/2022/11/beautiful-cat-portrait-close-up-scaled.jpg", true));
        mascotaRepository.save(new Mascota("Oliver", "Sphynx", 3, 4.1, "Problemas digestivos", "https://pymstatic.com/58113/conversions/rasgos-personalidad-de-gatos-wide_webp.webp", false));
        mascotaRepository.save(new Mascota("Lilly", "Maine Coon", 2, 5.0, "Alergia", "https://www.abc.es/xlsemanal/wp-content/uploads/sites/5/2023/10/como-entender-gatos-animales.jpg", true));
        mascotaRepository.save(new Mascota("Trixie", "Siamés", 1, 3.8, "Problemas dentales", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6M8la1eBKQsT5oTD813L68C313PFOuFLtjg&s", false));
        mascotaRepository.save(new Mascota("Rex", "Turco Van", 2, 4.3, "Infección respiratoria", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNlmQqkTa7XWHHg8AWHHVxuM0fAMay5QRqCw&s", true));
        mascotaRepository.save(new Mascota("Zara", "Sphynx", 3, 4.2, "Problemas de piel", "https://media.admagazine.com/photos/6272c673fa786b10d9e7780d/1:1/w_2000,h_2000,c_limit/Gato%20en%20mesa.jpg", false));
        mascotaRepository.save(new Mascota("Tommy", "Scottish Fold", 5, 4.4, "Artritis", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR85NT0d9snLMWnuXMkyqLoZp1V-Fh-muhXUQ&s", true));
        mascotaRepository.save(new Mascota("Ginger", "Siamés", 1, 3.9, "Diarrea", "https://images.ctfassets.net/denf86kkcx7r/7HUeRIOQ67bN5lIiOki9ak/080930351b7b94d4cef7ec73afff522d/ojosgato-29", false));
        mascotaRepository.save(new Mascota("Paws", "Bengala", 2, 4.1, "Problemas digestivos", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpxwVkMp-Ywwaw_nHmZ0ECWQARUXfoyPydvw&s", true));
        mascotaRepository.save(new Mascota("Whiskers", "Persa", 3, 4.0, "Inmunodeficiencia felina", "https://www.semana.com/resizer/v2/ZBGOE4OONZFWHCNBX62IC4XGYM.jpg?auth=239467349145c9956f034421e45259e12a778ffb204946658239289137f33bb6&smart=true&quality=75&width=1280&height=720", false));
        mascotaRepository.save(new Mascota("Lola", "Scottish Fold", 4, 4.2, "Alergia alimentaria", "https://s3.abcstatics.com/abc/www/multimedia/sociedad/2024/07/11/gato-RaZLibek03KjY2lBzGD2qEN-1200x840@diario_abc.jpg", true));
        mascotaRepository.save(new Mascota("Milo", "Turco Van", 5, 4.3, "Problemas respiratorios", "https://www.purina.es/sites/default/files/2021-12/Temperatura%20corporal%20de%20los%20gatos_teaser_0.jpg", false));
        mascotaRepository.save(new Mascota("Felix", "Maine Coon", 2, 5.2, "Problemas dentales", "https://gatogazzu.org/wp-content/uploads/2022/08/abuelo-de-los-gatos-930x620.jpg", true));
        mascotaRepository.save(new Mascota("Maggie", "Siamés", 1, 3.6, "Artritis", "https://paradispets.com/wp-content/uploads/2022/08/Gato_Bengali_Trepando_Arbol_Paradispets-600x450.jpg", false));
        mascotaRepository.save(new Mascota("Simba", "Sphynx", 4, 4.5, "Problemas digestivos", "https://www.semana.com/resizer/v2/CIHCDVOZDVDZJH3WEEVHBWIEXQ.jpg?auth=4039191476d08871fb55ec848583ab79d116a195944ad9801fea1cd071463723&smart=true&quality=75&width=1280", true));
        mascotaRepository.save(new Mascota("Charlie", "Bengala", 3, 4.4, "Infección respiratoria", "https://manchas.com/wp-content/uploads/2024/05/arena-gato.png", false));
        mascotaRepository.save(new Mascota("Luna", "Persa", 2, 4.1, "Alergia alimentaria", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwVwucpWLWNs2HBkpY4BWvy91ruBJQt4UXLA&s", true));
        mascotaRepository.save(new Mascota("Nina", "Maine Coon", 5, 5.1, "Problemas de piel", "https://hospitalveterinariodonostia.com/wp-content/uploads/2022/02/Personalidad-gatos-674x337.png", false));
        mascotaRepository.save(new Mascota("Oscar", "Scottish Fold", 4, 4.3, "Conjuntivitis", "https://caracol.com.co/resizer/v2/D72LMWGUFBCGPCG3BBZWYYEJGQ.jpg?auth=552e83952f719f5644534af5b51938818611533417438a78db1b56a8af31a677&width=650&height=488&quality=70&smart=true", true));
        mascotaRepository.save(new Mascota("Whiskers", "Turco Van", 2, 4.2, "Alergia", "https://hips.hearstapps.com/hmg-prod/images/gettyimages-1056403846-662750de6b3b0.jpg?crop=1xw:0.8404971085409253xh;center,top&resize=1200:*", false));
        mascotaRepository.save(new Mascota("Rex", "Siamés", 3, 4.1, "Problemas respiratorios", "https://nupec.com/wp-content/uploads/2022/09/fluffy-red-cat-resting-in-bright-sunlight-2022-08-01-02-05-31-utc-min.jpg", true));
        mascotaRepository.save(new Mascota("Bella", "Sphynx", 4, 3.8, "Problemas digestivos", "https://www.laclinicaveterinaria.com/wp-content/uploads/2023/09/Las-vibrisas-o-bigotes-de-los-gatos.webp", false));
        mascotaRepository.save(new Mascota("Cleo", "Bengala", 5, 4.4, "Inmunodeficiencia felina", "https://www.tiendanimal.es/articulos/wp-content/uploads/2022/03/Gato-Singapura-1200x900.jpg", true));
        mascotaRepository.save(new Mascota("Tommy", "Persa", 3, 4.0, "Alergia alimentaria", "https://cnnespanol.cnn.com/wp-content/uploads/2024/07/estereotipo-mujeres-gato-e1722197008180.webp?w=414&h=311&crop=1", false));
        mascotaRepository.save(new Mascota("Ginger", "Maine Coon", 2, 5.0, "Problemas respiratorios", "https://phantom-expansion.unidadeditorial.es/2f87033555d26483c0dc80c06caf5e48/resize/640/assets/multimedia/imagenes/2021/03/23/16164882584432.jpg", true));
        mascotaRepository.save(new Mascota("Simba", "Siamés", 1, 3.6, "Artritis", "https://urgenciesveterinaries.com/wp-content/uploads/2024/03/survet-toxoplasmosis-01.jpg", false));
        mascotaRepository.save(new Mascota("Maggie", "Turco Van", 4, 4.3, "Diarrea", "https://www.tugatobengali.com/wp-content/uploads/2022/04/exoticopelocorto-1.jpg", true));
        mascotaRepository.save(new Mascota("Oscar", "Bengala", 3, 4.0, "Problemas digestivos", "https://www.clinicanimal.vet/wp-content/uploads/2023/07/acariciando-gato.jpg", false));
        mascotaRepository.save(new Mascota("Lilly", "Sphynx", 2, 3.8, "Inmunodeficiencia felina", "https://imagenes.muyinteresante.com/files/article_social_75/uploads/2022/10/12/6346a7d3ec310.jpeg", true));
        mascotaRepository.save(new Mascota("Paws", "Persa", 4, 4.1, "Problemas dentales", "https://blog.laika.com.co/wp-content/uploads/2022/04/kabo-p6yH8VmGqxo-unsplash.jpg", false));





 
        // Agregar veterinarios a la base de datos
        veterinarioSave = new Veterinario("2222", "Dr. Juan Pérez", "Medicina General", "juan.perez@mail.com", "0001", "https://images.stockcake.com/public/e/9/3/e9369a0d-c4d0-4688-851b-07edafc906ff_large/veterinarian-examining-rabbit-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("3333", "Dra. Ana López", "Cirugía", "ana.lopez@mail.com", "0002", "https://images.stockcake.com/public/0/b/f/0bfe396f-1e8d-4232-a5c5-693ac3598e47_large/veterinarian-examining-parrot-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("5555", "Dr. Carlos Fernández", "Dermatología", "carlos.fernandez@mail.com", "0003", "https://images.stockcake.com/public/2/4/a/24af6981-08bc-4281-8063-2c8578141a0d_large/veterinarian-caring-dog-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("6666", "Dra. Marta González", "Oftalmología", "marta.gonzalez@mail.com", "0004", "https://images.stockcake.com/public/4/1/8/4187b99f-5eda-4342-a0c2-6673afac8a1e_large/vet-examining-dog-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("7777", "Dr. Luis Martínez", "Oncología", "luis.martinez@mail.com", "0005", "https://images.stockcake.com/public/f/7/3/f737970f-6e10-4353-aa82-d1b9dc3b94a3_large/veterinarian-examining-kitten-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("8888", "Dra. Clara Rivera", "Cardiología", "clara.rivera@mail.com", "0006", "https://images.stockcake.com/public/f/c/c/fccba0e9-a1d0-471d-aca3-3a99777233f8_large/puppy-vet-visit-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("9999", "Dr. Miguel Torres", "Neurología", "miguel.torres@mail.com", "0007", "https://images.stockcake.com/public/1/4/c/14ca6ccf-cfe1-4438-bd99-d8e618ec3602_large/veterinarian-examining-parrot-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("1010", "Dra. Patricia Morales", "Nutrición", "patricia.morales@mail.com", "0008", "https://images.stockcake.com/public/6/1/f/61fb54c5-0de2-42e0-85f2-a20c9a589684_large/veterinarian-examines-cat-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("1111", "Dr. Javier Hernández", "Anestesiología", "javier.hernandez@mail.com", "0009", "https://images.stockcake.com/public/9/8/0/98004d06-d724-404c-bcc1-411a13d39b1d_large/veterinarian-examining-owl-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("1212", "Dra. Sofía Romero", "Rehabilitación", "sofia.romero@mail.com", "0010", "https://images.stockcake.com/public/b/e/0/be000a37-483e-438c-853a-939929f13d89_large/vet-examining-dog-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("1313", "Dr. Andrés Vega", "Medicina Felina", "andres.vega@mail.com", "0011", "https://images.stockcake.com/public/c/a/2/ca2c500a-d923-4d3f-a8cb-70ceb0bd3f76_large/veterinarian-examining-iguana-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("1414", "Dra. Laura Fuentes", "Ortopedia", "laura.fuentes@mail.com", "0012", "https://images.stockcake.com/public/d/4/d/d4d0589c-746f-46e9-9e45-462ee737cc99_large/veterinarian-examining-kitten-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("1515", "Dr. Diego Navarro", "Odontología", "diego.navarro@mail.com", "0013", "https://images.stockcake.com/public/4/b/4/4b4f006c-a1fd-4b77-89a6-7f44e7417eb5_large/veterinarian-with-ferret-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("1616", "Dra. Gabriela Salinas", "Medicina Equina", "gabriela.salinas@mail.com", "0014", "https://images.stockcake.com/public/4/c/7/4c79c1df-36ec-4088-9db4-1fe420e91036_large/veterinarian-holding-hamster-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("1717", "Dr. Pedro Vargas", "Toxicología", "pedro.vargas@mail.com", "0015", "https://images.stockcake.com/public/4/5/b/45bdd751-c59b-46e1-a234-a8955a39fdb3_large/veterinarian-examining-rabbit-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("1818", "Dra. Valeria Medina", "Etología", "valeria.medina@mail.com", "0016", "https://images.stockcake.com/public/0/6/5/065f044e-fbdc-4d77-a176-e1c13f12246d_large/veterinarian-embraces-horse-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("1919", "Dr. Sergio Ramírez", "Radiología", "sergio.ramirez@mail.com", "0017", "https://images.stockcake.com/public/7/b/a/7babc602-7afb-488f-8976-6eee8f485f40_large/veterinarian-holding-kitten-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("2020", "Dra. Julia Ortiz", "Patología", "julia.ortiz@mail.com", "0018", "https://images.stockcake.com/public/2/0/6/20609582-d6ce-4426-8e70-de398a954c6f_large/veterinarian-examining-rabbit-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("2121", "Dr. Mario Mendoza", "Parasitología", "mario.mendoza@mail.com", "0019", "https://images.stockcake.com/public/4/a/0/4a05e197-c914-40af-ae7f-e9a12eae4330_large/veterinarian-examining-dog-stockcake.jpg");
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = new Veterinario("2223", "Dra. Mariana Castillo", "Reproducción", "mariana.castillo@mail.com", "0020", "https://images.stockcake.com/public/6/7/6/67625ce5-d76e-4582-adf0-82f2f2e80fb3_large/veterinarian-examining-cat-stockcake.jpg");


       
        // Asociar mascotas con cliente
        Long clientId = 1L; // Inicializamos el ID del cliente.
        int mascotasPorCliente = 2; // Número de mascotas que asignaremos a cada cliente.
        int clienteMaxId = 50; // El ID máximo de cliente para el ciclo.

        int mascotaCounter = 0; // Contador de mascotas procesadas.

        for (Mascota m : mascotaRepository.findAll()) { // Iteramos sobre todas las mascotas obtenidas del repositorio.
            // Buscamos el cliente actual usando el ID.
            Optional<Cliente> optionalCliente = clienteRepository.findById(clientId);

            if (optionalCliente.isPresent()) { // Verificamos si el cliente con el ID 'clientId' existe.
                m.setCliente(optionalCliente.get()); // Asociamos la mascota al cliente encontrado.
                mascotaRepository.save(m); // Guardamos la mascota actualizada en el repositorio.
            } else {
                // Manejo del caso en que el cliente no existe.
                System.out.println("Cliente con ID " + clientId + " no encontrado.");
            }

            mascotaCounter++; // Incrementamos el contador de mascotas procesadas.

            // Cuando se asignan 2 mascotas a un cliente, cambiamos al siguiente cliente.
            if (mascotaCounter % mascotasPorCliente == 0) {
                clientId++; // Incrementamos el ID del cliente para la siguiente asignación.
                // Si hemos alcanzado el ID máximo de cliente, volvemos a empezar desde el cliente con ID 1.
                if (clientId > clienteMaxId) {
                    clientId = 1L;
                }
            }
        }
        
        
        // Asignar tratamiento

        // Ruta al archivo Excel
        InputStream inputStream = getClass().getResourceAsStream("/static/excel/MEDICAMENTOS_VETERINARIA.xlsx");
        
        // Leer el archivo Excel
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Leer la primera hoja

        // Iterar sobre las filas del archivo
        Iterator<Row> rows = sheet.iterator();

        while (rows.hasNext()) {
            Row row = rows.next();

            // Suponiendo que la primera fila contiene encabezados
            if (row.getRowNum() == 0) {
                continue; // Omitir encabezados
            }

            // Suponiendo que el archivo tiene las columnas: nombre, dosis, descripción,
            // etc.
            String nombre = row.getCell(0).getStringCellValue();
            double precioVenta = row.getCell(1).getNumericCellValue();
            double precioCompra = row.getCell(2).getNumericCellValue();
            int unidadesDisponibles = (int) row.getCell(3).getNumericCellValue();
            int unidadesVendidas = (int) row.getCell(4).getNumericCellValue();
            // Otros campos que puedas tener...

            // Crear una nueva instancia de Droga
            Droga droga = new Droga();
            droga.setNombre(nombre);
            droga.setPrecioVenta(precioVenta);
            droga.setPrecioCompra(precioCompra);
            droga.setUnidadesDisponibles(unidadesDisponibles);
            droga.setUnidadesVendidas(unidadesVendidas);
            // Asignar otros campos...

            // Guardar el medicamento en la base de datos
            drogaRepository.save(droga);
        }

        // Cerrar el workbook y el InputStream
        workbook.close();
        inputStream.close();

        // Asociar mascotas a clientes
        List<Mascota> mascotas = mascotaRepository.findAll();
        List<Cliente> clientes = clienteRepository.findAll();

        int indiceMascota = 0;
        for (Cliente cliente : clientes) {
            for (int i = 0; i < 2 && indiceMascota < mascotas.size(); i++) {
                Mascota mascota = mascotas.get(indiceMascota);
                mascota.setCliente(cliente);
                 mascotaRepository.save(mascota);
                indiceMascota++;
            }
        }

        Calendar calendar = Calendar.getInstance();

        calendar.set(2023, Calendar.MAY, 10);
        tratamientoRepository.save(new Tratamiento(calendar.getTime()));

        calendar.set(2023, Calendar.JUNE, 15);
        tratamientoRepository.save(new Tratamiento(calendar.getTime()));

        calendar.set(2023, Calendar.JULY, 20);
        tratamientoRepository.save(new Tratamiento(calendar.getTime()));

        calendar.set(2023, Calendar.AUGUST, 25);
        tratamientoRepository.save(new Tratamiento(calendar.getTime()));

        calendar.set(2023, Calendar.SEPTEMBER, 30);
        tratamientoRepository.save(new Tratamiento(calendar.getTime()));

        calendar.set(2023, Calendar.OCTOBER, 5);
        tratamientoRepository.save(new Tratamiento(calendar.getTime()));

        calendar.set(2023, Calendar.NOVEMBER, 10);
        tratamientoRepository.save(new Tratamiento(calendar.getTime()));

        calendar.set(2023, Calendar.DECEMBER, 15);
        tratamientoRepository.save(new Tratamiento(calendar.getTime()));

        calendar.set(2024, Calendar.JANUARY, 20);
        tratamientoRepository.save(new Tratamiento(calendar.getTime()));

        calendar.set(2024, Calendar.FEBRUARY, 25);
        tratamientoRepository.save(new Tratamiento(calendar.getTime()));

        int cantidad_mascota = mascotaRepository.findAll().size();
        int cantidad_vet = veterinarioRepository.findAll().size();
        int cantidad_droga = drogaRepository.findAll().size();

        Random random = new Random(12345);

        for (Tratamiento tratamiento : tratamientoRepository.findAll()) {
            int mascota_id = random.nextInt(cantidad_mascota) + 1;
            int vet_id = random.nextInt(cantidad_vet) + 1;
            int droga_id = random.nextInt(cantidad_droga) + 1;

            Mascota mascota = mascotaRepository.findById(Long.valueOf(mascota_id)).get();
            Veterinario veterinario = veterinarioRepository.findById(Long.valueOf(vet_id)).get();
            Droga droga = drogaRepository.findById(Long.valueOf(droga_id)).get();

            tratamiento.setMascota(mascota);
            tratamiento.setVeterinario(veterinario);
            tratamiento.setDroga(droga);
        }


    }

    private UserEntity saveUserAdmin(Administrador administrador){
        UserEntity userEntity = new UserEntity();
        Role roles = roleRepository.findByName("ADMIN").get();
        userEntity.setUsername(administrador.getCorreo());
        userEntity.setPassword(passwordEncoder.encode(administrador.getPassword()));
        userEntity.setRoles(List.of(roles));
        return userRepository.save(userEntity);
    }

    private UserEntity saveUserCliente(Cliente cliente){
        UserEntity userEntity = new UserEntity();
        Role roles = roleRepository.findByName("CLIENTE").get();
        userEntity.setUsername(cliente.getCorreo());
        userEntity.setPassword(passwordEncoder.encode("123"));
        userEntity.setRoles(List.of(roles));
        return userRepository.save(userEntity);
    }

    private UserEntity saveUserVet(Veterinario veterinario){
        UserEntity userEntity = new UserEntity();
        Role roles = roleRepository.findByName("VETERINARIO").get();
        userEntity.setUsername(veterinario.getCorreo());
        userEntity.setPassword(passwordEncoder.encode(veterinario.getPassword()));
        userEntity.setRoles(List.of(roles));
        return userRepository.save(userEntity);
    }
}
