<template>
    <div class="p-10 flex-1 bg-gradient-to-bl from-white to-blue-100 h-screen">
        <div class="flex items-center justify-between border-b pb-4">
            <h1 class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                Configuración
            </h1>
            <img src="../../../assets/images/queue-easy-logo-without-background.png" alt="Imagen a la derecha"
                class="h-18 w-48 object-cover">
        </div>
        <center class="mt-6 mb-4">
            <h2 class="text-xl font-bold leading-tight tracking-tight text-gray-900">
                Actualizar datos
            </h2>
        </center>
        <form class="max-w-md mx-auto">
            <div class="relative z-0 w-full mb-5 group">
                <input v-model="selectedItem.contactEmail" type="email" name="floating_email" id="floating_email"
                    class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                    placeholder=" " required />
                <label for="floating_email"
                    class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 rtl:peer-focus:left-auto peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Correo
                    electrónico</label>
            </div>
            <div class="grid md:grid-cols-1 md:gap-6">
                <div class="relative z-0 w-full mb-5 group">
                    <input v-model="selectedItem.name" type="text" name="floating_first_name" id="floating_first_name"
                        class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                        placeholder=" " required />
                    <label for="floating_first_name"
                        class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">
                        Nombre de la Empresa</label>
                </div>
            </div>
            <div class="grid md:grid-cols-2 md:gap-6">
                <div class="relative z-0 w-full mb-5 group">
                    <input v-model="selectedItem.phoneNumber" type="tel" name="floating_phone" id="floating_phone"
                        class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                        placeholder=" " required />
                    <label for="floating_phone"
                        class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Número
                        de contacto</label>
                </div>
                <div class="relative z-0 w-full mb-5 group">
                    <input v-model="selectedItem.location" type="text" name="floating_company" id="floating_company"
                        class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                        placeholder=" " required />
                    <label for="floating_company"
                        class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Localización</label>
                </div>
            </div>
            <div class="flex items-center justify-center w-full">
                <label for="dropzone-file"
                    class="flex flex-col items-center justify-center w-full h-34 border-2 border-gray-300 border-dashed rounded-lg cursor-pointer bg-gray-50 dark:hover:bg-bray-800 dark:bg-gray-700 hover:bg-gray-100 dark:border-gray-600 dark:hover:border-gray-500 dark:hover:bg-gray-600">
                    <div class="flex flex-col items-center justify-center pt-5 pb-6">
                        <svg class="w-8 h-8 mb-4 text-gray-500 dark:text-gray-400" aria-hidden="true"
                            xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 16">
                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="M13 13h3a3 3 0 0 0 0-6h-.025A5.56 5.56 0 0 0 16 6.5 5.5 5.5 0 0 0 5.207 5.021C5.137 5.017 5.071 5 5 5a4 4 0 0 0 0 8h2.167M10 15V6m0 0L8 8m2-2 2 2" />
                        </svg>
                        <p class="mb-2 text-sm text-gray-500 dark:text-gray-400"><span class="font-semibold">Pulsa para
                                cargar</span> o arrastra y suelta</p>
                        <p class="text-xs text-gray-500 dark:text-gray-400">SVG, PNG or JPG</p>
                    </div>
                    <input id="dropzone-file" type="file" class="hidden" ref="fileInput" />
                </label>
            </div>
            <button @click="updateData()"
                class="mt-4 text-white inline-flex items-center bg-blue-400 hover:bg-blue-500 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                <svg xmlns="http://www.w3.org/2000/svg" class="mr-3 me-1 -ms-1 w-4 h-4" viewBox="0 0 20 20">
                    <path fill="currentColor" d="M7 20v-2h10v2zm4-4V7.825L8.4 10.4L7 9l5-5l5 5l-1.4 1.4L13 7.825V16z" />
                </svg>
                Actualizar
                datos</button>
        </form>
    </div>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";
import BACK_URL from "../../config/variables.js"

definePageMeta({
    layout: "admin-layout",
});

export default {
    setup() {
        const selectedItem = ref({
            name: '',
            location: '',
            contactEmail: '',
            phoneNumber: '',
            image: null
        });

        const fileInput = ref(null);

        // Defines el token del usuario registrado para pasarselo a la cabecera del request
        let token = null;
        if (typeof window !== "undefined") { // Comprueba que la ventana esta definida
            token = localStorage.getItem("token"); // Obtiene el token del local storage
        }
        const fetchData = async () => {
            try {
                const response = await axios.get(
                    `${BACK_URL}/api/company`,
                    {
                        headers: {
                            "ngrok-skip-browser-warning": "69420",
                            Authorization: `Bearer ${token}`,
                        },
                    });
                selectedItem.value = response.data;
            } catch (error) {
                console.error("Error fetching company data:", error);
            }
        };

        const updateData = async (event) => {
            try {
                const formData = new FormData();
                formData.append("new", new Blob([JSON.stringify(selectedItem.value)], { type: "application/json" }));
                if (fileInput.value && fileInput.value.files.length > 0) {
                    formData.append("file", fileInput.value.files[0]); // Adjunta el archivo de imagen que se ha subido
                }
                await axios.post(
                    `${BACK_URL}/api/company`,
                    formData,
                    {
                        headers: {
                            "ngrok-skip-browser-warning": "69420",
                            "Content-Type": "multipart/form-data",
                            Authorization: `Bearer ${token}`,
                        },
                    }
                );
            } catch (error) {
                console.error("Error updating data:", error);
                alert("Hubo un error al actualizar los datos");
            }
        };

        onMounted(fetchData);

        return {
            selectedItem,
            fileInput,
            updateData,
        }
    }
}
</script>