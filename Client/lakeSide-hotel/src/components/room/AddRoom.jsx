import React, { useState } from 'react'
import { addRoom } from '../utils/ApiFunctions'
import RoomTypeSelector from '../common/RoomTypeSelector'

const addroom = () => {
  const [newRoom, setNewRoom] = useState({
    photo: null,
    roomType: "",
    roomPrice: ""

  })

  const [imagePreview, setImagePreview] = useState("")
  const [sucessMessage, setSuccessMessage] = useState("")
  const [erroMessage, setErrorMessage] = useState("")

  const handleRoomInputChange = (e) => {
    const name = e.target.name
    let value = e.target.value
    if (name === "roomPrice") {
      if (!isNaN(value)) {
       value= parseInt(value)
      } else {

        value = ""
      }
    }
    setNewRoom({ ...newRoom, [name]: value })
  }

  const handleImageChange = (e) => {
    const selectedImage = e.target.files[0]
    setNewRoom({ ...newRoom, photo: selectedImage })
    setImagePreview(URL.createObjectURL(selectedImage))
  }

  const handletSubmit = async (e) => {
    e.preventDefault()//Evitar recargar la pagina en el submit
    try {
      const success = await addRoom(newRoom.photo, newRoom.roomType, newRoom.roomPrice)
      if (success !== undefined) {
        setSuccessMessage("A new room was added to the database")
        setNewRoom({ photo: null, roomType: "", roomPrice: "" })
        setImagePreview("")
        setErrorMessage("")
      } else {
        setErrorMessage("Error adding room")
      }
    } catch (error) {
      setErrorMessage(error.message)
    }
  }

  return (

    <>
      <section className='container, mt-5 mb-5'>
        <div className='row justfy-content-center'>
          <div className='col-md-8 col-lg-6'>
            <h2 className='mt-5 mb-2'>Add a new room</h2>
            <form onSubmit={handletSubmit}>
              <div className="mb-3">
                 <label className='for-label' htmlFor='roomType'>Room Type</label>
                <div className='container'>
                <RoomTypeSelector 
                handleNewRoomInputChange={handleRoomInputChange} 
                newRoom={newRoom}/>


                </div>
              </div>
              <div className="mb-3" >
              <label className='for-label' htmlFor='roomPrice'>Room Price</label>
              <input className='form-control' required
              id='roomPrice' 
              type='number' 
              name="roomPrice"
                value={newRoom.roomPrice}
                onChange={handleRoomInputChange}
              />
                                
              </div>
             

              <div className="mb-3" > <label className='for-label' htmlFor='photo'>Room photo</label>
                <input
                  id="photo" name='photo'
                  type='file'
                  className='form-control'
                  onChange={handleImageChange}
                />
                  {imagePreview && (
                    <img src={imagePreview}
                      alt="Preview Room Photo"
                      style={{ maxWidth: "400px", maxHeight: "400px" }}
                      className='mb-3' />
                  )}


              </div>

              <div className='d-grid d-md-flex mt-2'>

                <button
                  className='btn btn-outline-primary ml-5'
                > Save Room</button>
              </div>
            </form>
          </div>
        </div>

      </section>


    </>
  )

}

export default addroom