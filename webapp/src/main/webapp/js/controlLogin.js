/**
 * 
 */
 $(document).ready(function () {
        $('#loginInput').on('keyup',function () {
            if (($(this).val().length==0)||($('#mdpInput').val().length==0)) {
                $('#logButton').prop('disabled', true);
            } else {
                $('#logButton').prop('disabled', false);
            }
        });
        
        $('#mdpInput').on('keyup',function () {
            if (($(this).val().length==0)||($('#loginInput').val().length==0)) {
                $('#logButton').prop('disabled', true);
            } else {
                $('#logButton').prop('disabled', false);
            }
        });
        

        
        
        
        
        

 }
 );