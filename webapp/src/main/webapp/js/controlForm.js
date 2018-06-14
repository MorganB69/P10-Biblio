/**
 * 
 */
 $(document).ready(function () {
        $('#titre').on('keyup',function () {
            if ($(this).val().length <=3) {
                $('#rechButton').prop('disabled', true);
            } else {
                $('#rechButton').prop('disabled', false);
            }
        });
        
        if ($('#titre').val().length <=3) {
            $('#rechButton').prop('disabled', true);
        } else {
            $('#rechButton').prop('disabled', false);
        }
        
        
        
        
        

 }
 );