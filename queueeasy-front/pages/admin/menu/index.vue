  <template>
    <div class="p-10 flex-1 bg-gradient-to-bl from-white to-blue-100 h-screen">
      <div class="flex items-center justify-between border-b pb-4">
        <h1 class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
          Carta del restaurante
        </h1>
        <img src="../../../assets/images/queue-easy-logo-without-background.png" alt="Imagen a la derecha"
          class="h-18 w-48 object-cover">
      </div>
      <form class="mt-4 max-w-sm mx-auto">
        <select id="tipos"
          class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
          v-model="selectedType" @change="fetchData">
          <option value="hamburguesa" selected>Hamburguesas</option>
          <option value="entrante">Entrantes</option>
          <option value="ensalada">Ensaladas</option>
          <option value="sandwich">Sandwiches</option>
          <option value="postre">Postres</option>
          <option value="bebida">Bebidas</option>
        </select>
      </form>
      <div v-if="loading" class="mt-5 flex items-center justify-center dark:bg-gray-800 dark:border-gray-700">
        <div role="status">
          <svg aria-hidden="true" class="w-8 h-8 text-gray-200 animate-spin dark:text-gray-600 fill-blue-600"
            viewBox="0 0 100 101" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path
              d="M100 50.5908C100 78.2051 77.6142 100.591 50 100.591C22.3858 100.591 0 78.2051 0 50.5908C0 22.9766 22.3858 0.59082 50 0.59082C77.6142 0.59082 100 22.9766 100 50.5908ZM9.08144 50.5908C9.08144 73.1895 27.4013 91.5094 50 91.5094C72.5987 91.5094 90.9186 73.1895 90.9186 50.5908C90.9186 27.9921 72.5987 9.67226 50 9.67226C27.4013 9.67226 9.08144 27.9921 9.08144 50.5908Z"
              fill="currentColor" />
            <path
              d="M93.9676 39.0409C96.393 38.4038 97.8624 35.9116 97.0079 33.5539C95.2932 28.8227 92.871 24.3692 89.8167 20.348C85.8452 15.1192 80.8826 10.7238 75.2124 7.41289C69.5422 4.10194 63.2754 1.94025 56.7698 1.05124C51.7666 0.367541 46.6976 0.446843 41.7345 1.27873C39.2613 1.69328 37.813 4.19778 38.4501 6.62326C39.0873 9.04874 41.5694 10.4717 44.0505 10.1071C47.8511 9.54855 51.7191 9.52689 55.5402 10.0491C60.8642 10.7766 65.9928 12.5457 70.6331 15.2552C75.2735 17.9648 79.3347 21.5619 82.5849 25.841C84.9175 28.9121 86.7997 32.2913 88.1811 35.8758C89.083 38.2158 91.5421 39.6781 93.9676 39.0409Z"
              fill="currentFill" />
          </svg>
          <span class="sr-only">Loading...</span>
        </div>
      </div>
      <div class="relative shadow-md sm:rounded-lg mt-5">
        <div class="table-container">
          <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
            <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
              <tr>
                <th scope="col" class="px-6 py-3">Nombre</th>
                <th scope="col" class="px-6 py-3">Tipo</th>
                <th scope="col" class="px-6 py-3">Descripción</th>
                <th scope="col" class="px-6 py-3">Precio</th>
                <th scope="col" class="px-6 py-3">Imagen</th>
                <th scope="col" class="px-6 py-3">
                  <span>Acciones</span>
                </th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="item in data" :key="item.id"
                class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                  {{ item.name }}
                </th>
                <td class="px-6 py-4">{{ item.type }}</td>
                <td class="px-6 py-4">{{ item.description }}</td>
                <td class="px-6 py-4">{{ item.price }}€</td>
                <td class="px-6 py-4"><img :src="item.image[1]" style="width: 150px !important;" /></td>
                <td class="px-6 py-4">
                  <button @click="openPopupUpdate(item)" type="button"
                    class="focus:outline-none text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800">
                    Editar
                  </button>
                  <button @click="openPopupDelete(item.id)" type="button"
                    class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900">
                    Borrar
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <center>
        <button @click="openPopupCreate()" type="button"
          class="mt-10 max-w-40 text-white bg-blue-400 hover:bg-blue-500 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Añadir
          Plato</button>
      </center>
    </div>
    <!-- CENTER PARA MODAL DELETE-->
    <center v-if="showPopupDelete" class="absolute h-full w-full bg-black bg-opacity-20 flex items-center justify-center">
      <div class="relative p-4 w-full max-w-md max-h-full">
        <div class="bg-white rounded-lg shadow dark:bg-gray-700">
          <button @click="closePopup" type="button"
            class="absolute top-3 end-2.5 text-gray-400 bg-transparent rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
            data-modal-hide="popup-modal">
            <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
              <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
            </svg>
            <span class="sr-only">Close modal</span>
          </button>
          <div class="p-4 md:p-5 text-center">
            <svg class="mx-auto mb-4 text-gray-400 w-12 h-12 dark:text-gray-200" aria-hidden="true"
              xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
              <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                d="M10 11V6m0 8h.01M19 10a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
            </svg>
            <h3 class="mb-5 text-lg font-normal text-gray-500 dark:text-gray-400">
              ¿Quieres borrar este plato?
            </h3>
            <button @click="
              deleteData();
            closePopup();
            " type="button"
              class="text-white bg-red-600 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-red-300 dark:focus:ring-red-800 font-medium rounded-lg text-sm inline-flex items-center px-5 py-2.5 text-center">
              Si, estoy seguro
            </button>
            <button @click="closePopup" type="button"
              class="py-2.5 px-5 ms-3 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border border-gray-200 hover:bg-gray-100 hover:text-blue-700 focus:z-10 focus:ring-4 focus:ring-gray-100 dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white dark:hover:bg-gray-700">
              No, cancelar
            </button>
          </div>
        </div>
      </div>
    </center>
    <!-- CENTER PARA MODAL UPDATE-->
    <center v-if="showPopupUpdate" class="absolute h-full w-full bg-black bg-opacity-20 flex items-center justify-center">
      <div class="relative p-4 w-full max-w-md max-h-full">
        <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
          <div class="flex items-center justify-between p-4 md:p-5 border-b rounded-t dark:border-gray-600">
            <h3 class="text-lg font-semibold text-gray-900 dark:text-white">
              Actualizar plato
            </h3>
            <button @click="closePopup()" type="button"
              class="text-gray-400 bg-transparen rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
              data-modal-toggle="crud-modal">
              <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                  d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
              </svg>
              <span class="sr-only">Close modal</span>
            </button>
          </div>
          <form class="p-4 md:p-5" enctype="multipart/form-data">
            <div class="grid gap-4 mb-4 grid-cols-2">
              <div class="col-span-2">
                <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Nombre</label>
                <input v-model="selectedItem.name" type="text" name="name" id="name"
                  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                  placeholder="Nombre del plato" required="true" />
              </div>
              <div class="col-span-2 sm:col-span-1">
                <label for="price" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Precio</label>
                <input v-model="selectedItem.price" type="number" name="price" id="price"
                  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                  placeholder="$12,99" required="true" />
              </div>
              <div class="col-span-2 sm:col-span-1">
                <label for="category" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Tipo</label>
                <select v-model="selectedItem.type" id="category"
                  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                  required="true">
                  <option value="" disabled selected>Selecciona un tipo</option>
                  <option value="Hamburguesa">Hamburguesas</option>
                  <option value="Entrante">Entrantes</option>
                  <option value="Ensalada">Ensaladas</option>
                  <option value="Sandwich">Sandwiches</option>
                  <option value="Postre">Postres</option>
                  <option value="Bebida">Bebidas</option>
                </select>
              </div>
              <div class="col-span-2">
                <label for="description" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Descripción
                  del plato</label>
                <textarea v-model="selectedItem.description" id="description" rows="4"
                  class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                  placeholder="Escribe la descripción aqui" required="true"></textarea>
              </div>
              <div class="col-span-2">
                <label for="image" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Imagen
                  del plato</label>
                <input name="imagen" type="file" ref="fileInput" />
              </div>
            </div>
            <button @click="
              updateData();
            closePopup();
            "
              class="text-white inline-flex items-center bg-blue-400 hover:bg-blue-500 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
              <svg xmlns="http://www.w3.org/2000/svg" class="mr-3 me-1 -ms-1 w-4 h-4" viewBox="0 0 20 20">
                <path fill="currentColor" d="M7 20v-2h10v2zm4-4V7.825L8.4 10.4L7 9l5-5l5 5l-1.4 1.4L13 7.825V16z" />
              </svg>
              Actualizar plato
            </button>
          </form>
        </div>
      </div>
    </center>
    <!-- CENTER PARA MODAL CREATE-->
    <center v-if="showPopupCreate" class="absolute h-full w-full bg-black bg-opacity-20 flex items-center justify-center">
      <div class="relative p-4 w-full max-w-md max-h-full">
        <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
          <div class="flex items-center justify-between p-4 md:p-5 border-b rounded-t dark:border-gray-600">
            <h3 class="text-lg font-semibold text-gray-900 dark:text-white">
              Crear plato
            </h3>
            <button @click="closePopup()" type="button"
              class="text-gray-400 bg-transparen rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
              data-modal-toggle="crud-modal">
              <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                  d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
              </svg>
              <span class="sr-only">Close modal</span>
            </button>
          </div>
          <form class="p-4 md:p-5" enctype="multipart/form-data">
            <div class="grid gap-4 mb-4 grid-cols-2">
              <div class="col-span-2">
                <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Nombre</label>
                <input v-model="newItem.name" type="text" name="name" id="name"
                  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                  placeholder="Nombre del plato" required="true" />
              </div>
              <div class="col-span-2 sm:col-span-1">
                <label for="price" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Precio</label>
                <input v-model="newItem.price" type="number" name="price" id="price"
                  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                  placeholder="$12,99" required="true" />
              </div>
              <div class="col-span-2 sm:col-span-1">
                <label for="category" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Tipo</label>
                <select v-model="newItem.type" id="category"
                  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                  required="true">
                  <option value="" disabled selected>Selecciona un tipo</option>
                  <option value="Hamburguesa">Hamburguesas</option>
                  <option value="Entrante">Entrantes</option>
                  <option value="Ensalada">Ensaladas</option>
                  <option value="Sandwich">Sandwiches</option>
                  <option value="Postre">Postres</option>
                  <option value="Bebida">Bebidas</option>
                </select>
              </div>
              <div class="col-span-2">
                <label for="description" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Descripción
                  del plato</label>
                <textarea v-model="newItem.description" id="description" rows="4"
                  class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                  placeholder="Escribe la descripción aqui" required="true"></textarea>
              </div>
              <div class="col-span-2">
                <label for="image" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Imagen
                  del plato</label>
                <input name="imagen" type="file" ref="fileInput" />
              </div>
            </div>
            <button @click="
              postData();
            closePopup();
            " type="submit"
              class="text-white inline-flex items-center bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
              <svg xmlns="http://www.w3.org/2000/svg" class="mr-3 me-1 -ms-1 w-4 h-4" viewBox="0 0 20 20">
                <path fill="currentColor" d="M7 20v-2h10v2zm4-4V7.825L8.4 10.4L7 9l5-5l5 5l-1.4 1.4L13 7.825V16z" />
              </svg>
              Crear plato
            </button>
          </form>
        </div>
      </div>
    </center>
  </template>

  <script>
  import { ref } from "vue";
  import axios from "axios";
  import BACK_URL from "../../config/variables.js"

  export default {
    setup() {
      const showPopupDelete = ref(false);
      const showPopupUpdate = ref(false);
      const showPopupCreate = ref(false);
      const selectedType = ref("hamburguesa");
      const data = ref(null);
      const loading = ref(false);
      const selectedId = ref(0);
      const selectedItem = ref();
      const newItem = ref({
        name: "",
        price: 0,
        type: "",
        description: "",
        image: null
      });

      //Le pasas el token del usuario regisstrado para pasarselo a la cabecera del request
      let token = null;
      if (typeof window !== "undefined") {
        token = localStorage.getItem("token");
      }

      const fileInput = ref(null); // Variable reactiva para el input de archivo

      const openPopupDelete = (id) => {
        showPopupDelete.value = true;
        selectedId.value = id;
      };
      const openPopupUpdate = (item) => {

        const itemToUpdate = {
          id: item.id,
          name: item.name,
          price: item.price,
          type: item.type,
          description: item.description,
          image: item.image[0],
        } 

        selectedItem.value = itemToUpdate;
        showPopupUpdate.value = true;
      };


      const openPopupCreate = () => {
        showPopupCreate.value = true;
        newItem.value = { //Para que cuando le des a añadir no se guarden los datos anteriores
          name: "",
          price: 0,
          type: "",
          description: "",
          image: null
        };
      };

      const closePopup = () => {
        showPopupDelete.value = false;
        showPopupUpdate.value = false;
        showPopupCreate.value = false;
        selectedId.value = null;
      };

      // Llamada a la API para mostrar los platos por tipo
      const fetchData = async () => {
        if (selectedType.value) {
          loading.value = true;
          try {
            const response = await axios.get(
              `${BACK_URL}/api/plate/type/${selectedType.value}`,
              {
                headers: {
                  "ngrok-skip-browser-warning": "69420",
                  Authorization: `Bearer ${token}`,
                },
              }
            );

            const modifiedData = await Promise.all(
              response.data.map(async (item) => {
                if (item.image != null) {
                  const urlParts = item.image.split("/").slice(3).join("/");
                  const imageUrl = `${BACK_URL}/${urlParts}`;

                  // Fetch image content as blob
                  const imageResponse = await axios.get(imageUrl, {
                    headers: {
                      "ngrok-skip-browser-warning": "69420",
                      Authorization: `Bearer ${token}`,
                    },
                    responseType: "blob",
                  });

                  // Read image content as base64
                  const reader = new FileReader();
                  reader.readAsDataURL(imageResponse.data);

                  // Return a promise that resolves when FileReader is done
                  return new Promise((resolve, reject) => {
                    reader.onloadend = () => {
                      // Set item.image as an array containing URL and base64 content
                      item.image = [imageUrl, reader.result];
                      resolve(item);
                    };
                    reader.onerror = () => {
                      reject(reader.error);
                    };
                  });
                } else {
                  item.image = [null, null];
                }
                return item;
              })
            );
            
            console.log(modifiedData);

            data.value = modifiedData;
          } catch (error) {
            data.value = null;
            console.error("Error fetching data:", error);
          } finally {
            loading.value = false;
          }
        }
      };




      //Llamada a la API para borrar un plato
      const deleteData = async () => {
        try {
          const id = new Number(selectedId.value);
          await axios.delete(
            `${BACK_URL}/api/plate/${id}`,
            {
              headers: {
                "ngrok-skip-browser-warning": "69420",
                Authorization: `Bearer ${token}`,
              },
            }
          );
          data.value = null;
        } catch (error) {
          data.value = null;
          console.error("Error deleting data:", error);
        } finally {
          loading.value = false;
          fetchData();
        }
      };

      //Llamada a la API para actualizar un plato
      const updateData = async () => {
        try {
          console.log(selectedItem.value);
          const formData = new FormData();
          formData.append("new", new Blob([JSON.stringify(selectedItem.value)], { type: "application/json" }));

          if (fileInput.value) {
            formData.append("file", fileInput.value.files[0]); // Adjunta el archivo de imagen que se ha subido
          }

          await axios.put(
            `${BACK_URL}/api/plate`,
            formData,
            {
              headers: {
                "ngrok-skip-browser-warning": "69420",
                "Content-Type": "multipart/form-data",
                Authorization: `Bearer ${token}`,
              },
            }
          );
          data.value = null;
        } catch (error) {
          console.error("Error updating data:", error);
        } finally {
          fetchData();
          loading.value = false;
        }
      };
      //Llamada a la API para crear un plato
      const postData = async () => {
        try {
          const formData = new FormData();
          formData.append("new", new Blob([JSON.stringify(newItem.value)], { type: "application/json" }));
          if (fileInput.value) {
            formData.append("file", fileInput.value.files[0]); // Adjunta el archivo de imagen que se ha subido
          }

          await axios.post(
            `${BACK_URL}/api/plate`,
            formData,
            {
              headers: {
                "ngrok-skip-browser-warning": "69420",
                "Content-Type": "multipart/form-data",
                Authorization: `Bearer ${token}`,
              },
            }
          );
          data.value = null;
        } catch (error) {
          console.error("Error fetching data:", error);
        } finally {
          fetchData();
        }
      }

      onBeforeMount(fetchData);

      return {
        selectedType,
        data,
        loading,
        fetchData,
        showPopupDelete,
        showPopupUpdate,
        openPopupDelete,
        openPopupUpdate,
        showPopupCreate,
        openPopupCreate,
        closePopup,
        deleteData,
        selectedItem,
        updateData,
        postData,
        fileInput,
        newItem
      };
    },
  };


  definePageMeta({
    layout: "admin-layout",
  });
  </script>

  <style>
  .table-container {
    max-height: 100%;
    /* Ajusta la altura según sea necesario */
    overflow-y: auto;
    position: relative;
  }

  thead {
    position: sticky;
    top: 0;
    z-index: 10;
  }

  thead tr {
    background: inherit;
    /* Mantiene el estilo de fondo del encabezado */
  }

  tbody {
    display: block;
    max-height: 55vh;
    /* Ajusta la altura según sea necesario */
    overflow-y: auto;
  }

  thead,
  tbody tr {
    display: table;
    width: 100%;
    table-layout: fixed;
  }

  .absolute {
    z-index: 20;
  }
  </style>