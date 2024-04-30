import axios from "axios";
export const api=axios.create({
    baseURL:"http://localhost:8080"

})

/*Esta funcion agrega una nueva habitacion a la base de datos  */
export async function addRoom(photo, roomType, roomPrice){
    const formData=new FormData()
    formData.append("photo", photo)
    formData.append("roomType",roomType)
    formData.append("roomPrice",roomPrice)
    const response = await api.post("/rooms/add/new-room", formData)
    if(response.status ===201)//Esto significa que va todo bien el 201, no como el 404
    {

        return true
    }else{

        return false
    }
}
/*Esta funcion devuelve todos los tipos de habitacions de la base de datos */
export async function getRoomTypes(){
    try{
        const response= await api.get("/rooms/room-types")
        return response.data
    }catch(error){
        throw new Error("Error fetching room types");

    }

}

//Agregar datos a la base de datos directamente con cada tipo