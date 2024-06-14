package com.queueeasy.apirest;

import com.queueeasy.apirest.repository.CompanyRepository;
import com.queueeasy.apirest.repository.PlateRepository;
import com.queueeasy.apirest.repository.UserRepository;
import com.queueeasy.apirest.service.storage.StorageService;
import com.queueeasy.apirest.repository.QueueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, StorageService storageService, CompanyRepository companyRepository, PlateRepository plateRepository, QueueRepository queueRepository) {
        return args -> {

			/*
			//CREATE PERMISSIONS
			PermissionModel createPermission = PermissionModel.builder()
					.name("CREATE")
					.build();
			PermissionModel readPermission = PermissionModel.builder()
					.name("READ")
					.build();
			PermissionModel deletePermission = PermissionModel.builder()
					.name("DELETE")
					.build();
			PermissionModel updatePermission = PermissionModel.builder()
					.name("UPDATE")
					.build();

			//CREATE ROLES
			RoleModel roleAdmin = RoleModel.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();
			RoleModel roleUser = RoleModel.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(createPermission, readPermission))
					.build();
			//CREATE USERS
			UserModel userJavier = UserModel.builder()
					.username("Javier@gmail.com")
					.password(new BCryptPasswordEncoder().encode("1234"))
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();
			UserModel userAlvaro = UserModel.builder()
					.username("Alvaro@gmail.com")
					.password(new BCryptPasswordEncoder().encode("1234"))
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();
			UserModel userDavid = UserModel.builder()
					.username("David@gmail.com")
					.password(new BCryptPasswordEncoder().encode("1234"))
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();
			UserModel userDaniel = UserModel.builder()
					.username("Daniel@gmail.com")
					.password(new BCryptPasswordEncoder().encode("4321"))
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			userRepository.saveAll(List.of(userJavier, userAlvaro, userDavid, userDaniel));*/
        };
    }
}
